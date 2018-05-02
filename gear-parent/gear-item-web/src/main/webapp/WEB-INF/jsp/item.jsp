<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>${item.title } - 齿轮工艺系统</title>
	<script>var jdpts = new Object(); jdpts._st = new Date().getTime();</script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" type="text/css" href="/css/taotao.css" media="all" />
	<link rel="stylesheet" type="text/css" href="/css/pshow.css" media="all" />
	<script type="text/javascript">
    	window.pageConfig = {
			compatible: true,
       		product: {
				skuid: 1221882,
				name: '\u957f\u8679\uff08\u0043\u0048\u0041\u004e\u0047\u0048\u004f\u004e\u0047\uff09\u004c\u0045\u0044\u0034\u0032\u0035\u0033\u0038\u0045\u0053\u0020\u0034\u0032\u82f1\u5bf8\u0020\u7a84\u8fb9\u84dd\u5149\u004c\u0045\u0044\u6db2\u6676\u7535\u89c6\uff08\u9ed1\u8272\uff09',
				skuidkey:'E804B1D153D29E36088A33A134D85EEA',
				href: 'http://item.jd.com/1221882.html',
				src: 'jfs/t304/157/750353441/93159/e4ee9876/54227256N20d4f5ec.jpg',
				cat: [737,794,798],
				brand: 20710,
				nBrand: 20710,
				tips: false,
				type: 1,
				venderId:0,
				shopId:'0',
				TJ:'0',
				specialAttrs:["HYKHSP-0","isHaveYB","isSelfService-0","isWeChatStock-0","isCanUseJQ","isOverseaPurchase-0","YuShou","is7ToReturn-1","isCanVAT"],
				videoPath:'',
				HM:'0'
			}
		};
	</script>
	<style>
		body{
			background-color: #E6E6E6;
		}
	</style>
</head>
<body version="140120">
<script type="text/javascript">try{(function(flag){ if(!flag){return;} if(window.location.hash == '#m'){var exp = new Date();exp.setTime(exp.getTime() + 30 * 24 * 60 * 60 * 1000);document.cookie = "pcm=1;expires=" + exp.toGMTString() + ";path=/;domain=jd.com";return;}else{var cook=document.cookie.match(new RegExp("(^| )pcm=([^;]*)(;|$)"));var flag=false;if(cook&&cook.length>2&&unescape(cook[2])=="1"){flag=true;}} var userAgent = navigator.userAgent; if(userAgent){ userAgent = userAgent.toUpperCase();if(userAgent.indexOf("PAD")>-1){return;} var mobilePhoneList = ["IOS","IPHONE","ANDROID","WINDOWS PHONE"];for(var i=0,len=mobilePhoneList.length;i<len;i++){ if(userAgent.indexOf(mobilePhoneList[i])>-1){var url="http://m.jd.com/product/"+pageConfig.product.skuid+".html";if(flag){pageConfig.product.showtouchurl=true;}else{window.location.href = url;}break;}}}})((function(){var json={"6881":3,"1195":3,"10011":3,"6980":3,"12360":3};if(json[pageConfig.product.cat[0]+""]==1||json[pageConfig.product.cat[1]+""]==2||json[pageConfig.product.cat[2]+""]==3){return false;}else{return true;}})());}catch(e){}</script>
<!-- header start -->
<jsp:include page="commons/header.jsp" />
<!-- header end -->

<div class="w">
	<div id="product-intro" >
		<div id="name">
			<h1>${item.title }</h1>
		</div><!--name end-->
		<script type='text/javascript'>var warestatus = 1; var eleSkuIdKey =[];</script>
		<div style="float: left;width: 100%;">
					<br/>
			<div style="float: left;width: 50%">
				<img src="/images/gear.png" alt="" style="margin-left: 30%;"/>
			</div>
			<br/>
			<div style="float: left;width: 40%">
				<div><h1>名称：<span style="color: red;">${item.title }</span></h1></div>
				<br/>
				<div><h1>分度圆直径：<span>${item.diameter }</span></h1></div>
				<br/>
				<div><h1>齿数：<span>${item.teeth }</span></h1></div>
				<br/>
				<div><h1>模数：<span>${item.models }</span></h1></div>
			</div>

		</div>

		<div id="preview">
			<div id="spec-n1" class="jqzoom" clstag="shangpin|keycount|product|spec-n1">
				<img data-img="1" width="350" height="350" src="${item.images[0]}" alt="${item.title}"  jqimg="${item.images[0]}"/>
			</div>

			<div id="spec-list" clstag="shangpin|keycount|product|spec-n5">
				<a href="javascript:;" class="spec-control" id="spec-forward"></a>
				<a href="javascript:;" class="spec-control" id="spec-backward"></a>
				<div class="spec-items">
					<ul class="lh">
						<c:forEach items="${item.images}" var="pic" varStatus="status">
							<c:choose>
								<c:when test="${status.index == 0 }">
									<li>
										<img data-img="1" class="img-hover"  alt="${item.title}" src="${pic}" width="50" height="50" data-url="${pic}">
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<img data-img="1" alt="${item.title}" src="${pic}" width="50" height="50" data-url="${pic}">
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div><!--preview end-->
<div class="mc" data-widget="tab-content" id="product-detail-1">
	<h1><p style="text-align: center">齿轮工艺信息：</p></h1><br/>
	<div id="item-desc" class="detail-content">
		${itemDesc.gearCraftsDesc}
	</div>
</div>

<div id="name"></div>
<!-- footer start -->
<jsp:include page="commons/footer.jsp" />
<!-- footer end -->
<script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
<script type="text/javascript" src="/js/lib-v1.js"></script>
<script type="text/javascript" src="/js/product.js"></script>
<script type="text/javascript">
	var itemControl = {
			param:{
				descUrl:"/item/desc/"
			},
			//请求商品描述
			getItemDesc:function(itemId) {
				$.get(itemControl.param.descUrl+itemId+"", function(data){
					//返回商品描述的html，直接显示到页面
					$("#item-desc").append(data);
				});
			}
	};
	$(function(){
		//取商品id
		var itemId = "${item.gearId}";
		//延迟一秒加载商品描述信息
		setTimeout(function(){
			itemControl.getItemDesc(itemId);
		},1000);
	});
</script>
</body>
</html>