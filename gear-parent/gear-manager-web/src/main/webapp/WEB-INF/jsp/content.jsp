<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false" style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false" style="width:250px;padding:5px">
            <ul id="contentCategoryTree" class="easyui-tree" data-options="url:'/gear/category/list',animate: true,method : 'GET'">
            </ul>
        </div>
        <div data-options="region:'center'" style="padding:5px">
            <table class="easyui-datagrid contentList" id="contentList" data-options="toolbar:contentListToolbar,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:20,url:'/gear/query/list',queryParams:{categoryId:0}">
		    <thead>
		        <tr>
		            <th data-options="field:'gearId',width:30">ID</th>
		            <th data-options="field:'title',width:120">齿轮标题</th>
		            <th data-options="field:'teeth',width:100">齿轮齿数</th>
		            <th data-options="field:'diameter',width:100">直径</th>
		            <th data-options="field:'models',width:100">齿轮模数</th>
		            <th data-options="field:'description',width:120">齿轮简介</th>
		            <th data-options="field:'image',width:50,align:'center',formatter:TAOTAO.formatUrl">图片</th>
		            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
		            <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
		        </tr>
		    </thead>
		</table>
        </div>
    </div>
</div>
<script type="text/javascript">
    function getSelectionsIds(){
        var gearList = $("#contentList");
        var sels = gearList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].gearId);
        }
        ids = ids.join(",");
        return ids;
    }
</script>
<script type="text/javascript">
$(function(){
	var tree = $("#contentCategoryTree");
	var datagrid = $("#contentList");
	tree.tree({
		onClick : function(node){
			if(tree.tree("isLeaf",node.target)){
				datagrid.datagrid('reload', {
					categoryId :node.id
		        });
			}
		}
	});
});
var contentListToolbar = [{
    text:'新增',
    iconCls:'icon-add',
    handler:function(){
    	var node = $("#contentCategoryTree").tree("getSelected");
    	if(!node || !$("#contentCategoryTree").tree("isLeaf",node.target)){
    		$.messager.alert('提示','新增内容必须选择一个内容分类!');
    		return ;
    	}
    	TT.createWindow({
			url : "/content-add"
		}); 
    }
},{
    text:'编辑',
    iconCls:'icon-edit',
    handler:function(){
    	var ids = getSelectionsIds();
    	if(ids.length == 0){
    	    console.log(ids);
            $.messager.alert(ids);
    		$.messager.alert('提示','必须选择一个内容才能编辑!');
    		return ;
    	}
    	if(ids.indexOf(',') > 0){
    		$.messager.alert('提示','只能选择一个内容!');
    		return ;
    	}
		TT.createWindow({
			url : "/content-edit",
			onLoad : function(){
				var data = $("#contentList").datagrid("getSelections")[0];
				$("#contentEditForm").form("load",data);

				// 实现图片
				if(data.image){
					$("#contentEditForm [name=image]").after("<a href='"+data.image+"' target='_blank'><img src='"+data.image+"' width='80' height='50'/></a>");
				}
				
				contentEditEditor.html(data.gearCraftsDesc);
			}
		});    	
    }
},{
    text:'删除',
    iconCls:'icon-cancel',
    handler:function(){
    	var ids = getSelectionsIds();
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中商品!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的内容吗？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("/gear/delete",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除内容成功!',undefined,function(){
        					$("#contentList").datagrid("reload");
        				});
        			}
        		});
    	    }
    	});
    }
}];
</script>