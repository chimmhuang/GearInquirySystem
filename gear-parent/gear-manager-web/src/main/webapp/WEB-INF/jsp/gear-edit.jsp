<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="gearEditForm" class="gearForm" method="post">
		<input type="hidden" name="gearId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>齿轮类目:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a>
	            	<input type="hidden" name="cid" style="width: 280px;"></input>	
	            </td>
	        </tr>
	        <tr>
	            <td>齿轮名称:</td>
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
			<tr>
				<td>齿轮齿数:</td>
				<td><input class="easyui-numberbox" type="text" name="teeth" data-options="min:0,max:99999999,required:true" />
				</td>
			</tr>
			<tr>
				<td>齿轮模数:</td>
				<td><input class="easyui-numberbox" type="text" name="models" data-options="min:0,max:99999999,required:true" />
				</td>
			</tr>
	        <tr>
	            <td>齿轮图片:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                <input type="hidden" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>齿轮描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var gearEditEditor ;
	$(function(){
		//实例化编辑器
		gearEditEditor = TAOTAO.createEditor("#gearEditForm [name=desc]");
	});
	
	function submitForm(){
		if(!$('#gearEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		var paramJson = [];
		$("#gearEditForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		paramJson = JSON.stringify(paramJson);
		
		$("#gearEditForm [name=itemParams]").val(paramJson);
		
		$.post("/gear/update",$("#gearEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','齿轮修改成功!','info',function(){
					$("#itemEditWindow").window('close');
					$("#itemList").datagrid("reload");
				});
			}
		});
	}
</script>
