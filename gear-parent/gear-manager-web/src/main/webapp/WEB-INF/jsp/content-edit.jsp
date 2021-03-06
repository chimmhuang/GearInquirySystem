<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="contentEditForm" class="gearForm" method="post">
		<input type="hidden" name="cid"/>
		<input type="hidden" name="gearId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>内容标题:</td>
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
			<tr>
				<td>内容简介:</td>
				<td><input class="easyui-textbox" type="text" name="description" style="width: 280px;"></input></td>
			</tr>
			<tr>
				<td>齿轮齿数:</td>
				<td><input class="easyui-numberbox" type="text" name="teeth" data-options="min:0,max:99999999,required:true" />
				</td>
			</tr>
			<tr>
				<td>齿轮分度圆直径(mm):</td>
				<td><input class="easyui-numberbox" type="text" name="diameter" data-options="min:0,max:99999999,required:true" />
				</td>
			</tr>
			<tr>
				<td>图片:</td>
				<td>
					<input type="hidden" name="image" />
					<a href="javascript:void(0)" class="easyui-linkbutton onePicUpload">图片上传</a>
				</td>
			</tr>
	        <tr>
	            <td>齿轮工艺介绍:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="content"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentEditPage.submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentEditPage.clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
var contentEditEditor ;
$(function(){
	contentEditEditor = TT.createEditor("#contentEditForm [name=content]");
	TT.initOnePicUpload();
});

var contentEditPage = {
		submitForm : function(){
			if(!$('#contentEditForm').form('validate')){
				$.messager.alert('提示','表单还未填写完成!');
				return ;
			}
			contentEditEditor.sync();
			
			$.post("/content/edit",$("#contentEditForm").serialize(), function(data){
				if(data.status == 200){
					$.messager.alert('提示','新增内容成功!');
					$("#contentList").datagrid("reload");
					TT.closeCurrentWindow();
				}
			});
		},
		clearForm : function(){
			
		}
};

</script>