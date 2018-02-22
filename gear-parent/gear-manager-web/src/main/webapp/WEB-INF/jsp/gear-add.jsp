<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>


<div style="padding:10px 10px 10px 10px">
	<form id="gearAddForm" class="gearForm" method="post">
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
				<td><input id="gearTeeth" class="easyui-numberbox" type="text" name="teeth" data-options="min:0,max:99999999,required:true" />
				</td>
			</tr>
			<tr>
				<td>齿轮分度圆直径(mm):</td>
				<td><input id="gearDiameter" class="easyui-numberbox" type="text" name="diameter" data-options="min:0,max:99999999,required:true" />
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
	    <input type="hidden" name="gearParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var gearAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		gearAddEditor = TAOTAO.createEditor("#gearAddForm [name=desc]");
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//TAOTAO.changeItemParam(node, "gearAddForm");
		}});
	});
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#gearAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的商品描述
		gearAddEditor.sync();
		$.post("/gear/save",$("#gearAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','添加齿轮成功!');
			}
		});
	}
	
	function clearForm(){
		$('#gearAddForm').form('reset');
		gearAddEditor.html('');
	}
</script>
