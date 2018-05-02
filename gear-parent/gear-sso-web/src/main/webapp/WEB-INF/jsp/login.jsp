<%--
  Created by IntelliJ IDEA.
  User: 帅。
  Date: 2018/4/25
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录界面</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/style.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
    <style>
        body{color:#fff; font-family:"微软雅黑"; font-size:14px;}
        .wrap1{position:absolute; top:0; right:0; bottom:0; left:0; margin:auto }/*把整个屏幕真正撑开--而且能自己实现居中*/
        .main_content{background:url(images/main_bg.png) repeat; margin-left:auto; margin-right:auto; text-align:left; float:none; border-radius:8px;}
        .form-group{position:relative;}
        .login_btn{display:block; background:#3872f6; color:#fff; font-size:15px; width:100%; line-height:50px; border-radius:3px; border:none; }
        .login_input{width:100%; border:1px solid #3872f6; border-radius:3px; line-height:40px; padding:2px 5px 2px 30px; background:none;}
        .icon_font{position:absolute; bottom:15px; left:10px; font-size:18px; color:#3872f6;}
        .font16{font-size:16px;}
        .mg-t20{margin-top:20px;}
        @media (min-width:200px){.pd-xs-20{padding:20px;}}
        @media (min-width:768px){.pd-sm-50{padding:50px;}}
        #grad {
            background: -webkit-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Safari 5.1 - 6.0 */
            background: -o-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Opera 11.1 - 12.0 */
            background: -moz-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Firefox 3.6 - 15 */
            background: linear-gradient(#4990c1, #52a3d2, #6186a3); /* 标准的语法 */
        }
    </style>

</head>

<body style="background:url(images/bg.jpg) no-repeat;">

<div class="container wrap1" style="height:450px;">
    <h2 class="mg-b20 text-center">欢迎使用齿轮管理系统</h2>
    <div class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
        <p class="text-center font16">用户登录</p>
        <form id="formlogin" method="post">
            <div class="form-group mg-t20">
                <i class="fa fa-user-circle" style="position: absolute;left:1%;top:35%"></i>
                <input type="text" class="login_input" id="Email1" name="username" placeholder="请输入用户名" />
            </div>
            <div class="form-group mg-t20">
                <i class="fa fa-key" style="position: absolute;left: 1%;top: 35%;"></i>
                <input type="password" class="login_input" id="Password1" name="password" placeholder="请输入密码" />
            </div>
            <div class="checkbox mg-b25">
                <label>
                    <input type="checkbox" name="checkbox" id="Checkbox1"/>十天内免登陆
                </label>
            </div>
            <button  class="login_btn" onclick="login()">登 录</button>
        </form>
    </div><!--row end-->
</div><!--container end-->

</body>
<script type="text/javascript">

    var LOGIN = {
        checkInput:function () {
            if ($("#Email1").val() == ""){
                alert("用户名不能为空");
                $("#Email1").focus();
                return false;
            }
            if ($("#Password1").val() == ""){
                alert("密码不能为空");
                $("#Password1").focus();
                return false;
            }
            return true;
        },
        doLogin:function () {
            var username = $("#Email1").val();
            var password = $("#Password1").val();
            var checkbox = $("#Checkbox1").is(':checked');
//            alert("开始执行登陆");
//            $.post("/user/login",$("#formlogin").serialize(),function (data) {
//                if (data.status == 200){
//                    alert("登陆成功！");
//                    location.href = "http://localhost:8081";
//                }else {
//                    alert(data.msg);
//                }
//            });
            $.ajax({
                url:"/user/login",
                async:false,//这一步是非常重要的，作用是设置为同步执行
                type:"POST",
                data:$("#formlogin").serialize(),
                success:function (data) {
                    if (data.status == 200){
                        alert("登陆成功！");
                        window.open("http://localhost:8081");
                    }else {
                        alert(data.msg);
                    }
                }
            });
        },
        login:function () {
            if (this.checkInput()){
                this.doLogin();
            }
        }
    }
    function login() {
        LOGIN.login();
    }
</script>
</html>
