<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机械齿轮后台管理系统</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/taotao.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
	body{
		background-color: #E6E6E6;
	}
</style>
</head>
<body class="easyui-layout">
    <div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
    	<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
         	<li>
         		<span>齿轮管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'gear-add'}">新增齿轮</li>
	         		<li data-options="attributes:{'url':'gear-list'}">查询齿轮</li>
	         	</ul>
         	</li>
			<li>
				<span>分类管理</span>
				<ul>
					<li data-options="attributes:{'url':'content-category'}">齿轮分类管理</li>
					<li data-options="attributes:{'url':'content'}">分类内容管理</li>
				</ul>
			</li>
         </ul>
    </div>
    <div data-options="region:'center',title:''">
    	<div id="tabs" class="easyui-tabs">
		    <div title="首页" style="padding:20px;">
				<div align="center">
					<h1 style="color: red;">欢迎使用齿轮管理系统</h1>
				</div>
				<div align="center">
					<img src="/images/gear_1.jpg" width="500px" >
				</div>
		    </div>
		</div>
		<div align="center">
			<p style="font-family: 'Microsoft YaHei UI'">2018 &copy 齿轮工艺系统  <a href="https://github.com/chimmhuang/GearInquirySystem" target="_blank" style="text-decoration: none;color: green;">  GitHub源代码 </a></p>
		</div>
    </div>

<script type="text/javascript">
$(function(){
	$('#menu').tree({
		onClick: function(node){
			if($('#menu').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				var tab = tabs.tabs("getTab",node.text);
				if(tab){
					tabs.tabs("select",node.text);
				}else{
					tabs.tabs('add',{
					    title:node.text,
					    href: node.attributes.url,
					    closable:true,
					    bodyCls:"content"
					});
				}
			}
		}
	});
});
</script>
</body>
</html>