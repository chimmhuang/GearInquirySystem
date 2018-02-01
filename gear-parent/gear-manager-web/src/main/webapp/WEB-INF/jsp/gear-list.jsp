<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="gearList" title="齿轮列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/gear/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'gearId',width:60">齿轮ID</th>
            <th data-options="field:'title',width:200">齿轮名称</th>
            <th data-options="field:'description',width:100">齿轮介绍</th>
            <th data-options="field:'teeth',width:100">齿数</th>
            <th data-options="field:'models',width:100">模数</th>
            <th data-options="field:'cid',width:100">叶子类目</th>
            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
        </tr>
    </thead>
</table>
<div id="gearEditWindow" class="easyui-window" title="编辑齿轮" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/gear-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var gearList = $("#gearList");
    	var sels = gearList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].gearId);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$(".tree-title:contains('新增齿轮')").parent().click();
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
        	
        	$("#gearEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#gearList").datagrid("getSelections")[0];
        			$("#gearEditForm").form("load",data);

        			// 加载商品描述
        			$.getJSON('/gear/desc/'+data.gearId,function(_data){
        				if(_data.status == 200){
//        				    alert(data.gearId);
//        				    alert(_data.data.description);
        					//UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
        					gearEditEditor.html(_data.data.description);
        				}
        			});
        			
        			TAOTAO.init({
        				"pics" : data.image,
        				"cid" : data.cid,
        				fun:function(node){
        					TAOTAO.changeItemParam(node, "gearEditForm");
        				}
        			});
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中齿轮!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的齿轮吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/gear/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除齿轮成功!',undefined,function(){
            					$("#gearList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>