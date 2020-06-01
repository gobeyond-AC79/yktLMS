<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>欢迎登录易课堂</title>
    <style>
        /*html {
            -webkit-filter: grayscale(100%);
        }*/
        * {
            margin: 0px;
            padding: 0px;
        }
        body {
            /*background-color: #8ac4e0;*/
            background: url("static/image/hu.jpg");
        }

        .login {
            position: relative;
            width: 450px;
            height: 700px;
            background-color: rgb(223, 217, 217);
            margin: 140px auto;
            border-radius: 10px 10px 10px 10px;
            box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
            transition: all 0.7s;
        }
        .login:hover {
            background-color: rgb(167, 177, 157);
        }
        .hy {
            position: absolute;
            text-align: center;
            border-bottom: 2px solid #8c9599;
            font-size: 21px;
            top: 46px;
            left: 94px;
        }
        .pic {
            background-color: rgb(124, 208, 223);
            position: absolute;
            width: 271px;
            height: 271px;
            top: 100px;
            left: 95px;
            border-radius: 50%;
            background: url(static/image/xue.png);
            transition: all 1.5s;
        }
        .pic:hover {
            transform: rotateY(180deg);
        }
        .msg {
            position: absolute;
            top: 390px;
            left: 66px;
        }
        .zh {
            font-size: 16px;
        }
        .zh input {
            background-color: #f6f6f6;
            padding: 15px 70px;
            text-align: center;
            text-decoration: none;
            margin: 5px;
            border: none;
            border-radius: 14px;
        }
        .mm input {
            background-color: #f6f6f6;
            padding: 15px 70px;
            text-align: center;
            text-decoration: none;
            margin: 5px;
            border: none;
            border-radius: 14px;
        }
        .yzm input {
            background-color: #f6f6f6;
            padding: 15px 5px;
            text-align: center;
            text-decoration: none;
            margin: 5px;
            border: none;
            border-radius: 14px;
        }
        .btn {
            position: absolute;
            top: 310px;
            left: 27%;
        }
        .btn button {
            background-color: rgb(79, 190, 238);
            border-radius: 15px;
            border: none;
            transition: all 0.5s;
            outline: none;
        }
        button:active {
            background-color: #d1d1d1;
        }
        .rememberMe {
            position: absolute;
            top: 575px;
            left: 75px;
            font-size: 10px;
            font-weight: 300;
        }
    </style>

    <script>
        function check(form) {
            var username = form.userName.value;
            if (username.length === 0) {
                alert("用户名为空！请输入用户名");
                form.userName.focus();
                return false;
            }
            var password = form.userPassword.value;
            if (password.length === 0) {
                alert("密码为空！请输入密码");
                form.userPassword.focus();
                return false;
            }
            var verifyCode = form.verifyCode.value;
            if (verifyCode.length === 0) {
                alert("验证码不能为空！");
                form.verifyCode.focus();
                return false;
            }
        }
    </script>

</head>
<body>
<!-- 登录界面 -->
<div class="login">
    <!-- 字体 -->
    <div class="hy">
        <span>欢迎登录YKT课堂管理系统</span>
    </div>
    <!-- 头像 -->
    <div class="pic"></div>
    <form class="form-horizontal" role="form" action="/login" id="from" method="post" onSubmit="return check(this)">
        <div class="msg">
            <#--span标签-->
            <!-- 账号 -->
            <div class="zh">
                <input type="text" class="form-control" name="userName" id="zh" placeholder="账号" />
            </div>
            <!-- 密码 -->
            <div class="mm">
                <input type="password" class="form-control" name="userPassword" id="mm" placeholder="密码" />
            </div>
            <!-- 验证码 -->
            <div class="yzm">
                <input type="text" name="verifyCode" id="yzm" placeholder="验证码" />
                <img id="verifyCode" src="/getCode" onclick="refreshCode()">
            </div>
        </div>
        <div class="rememberMe">
            <input type="checkbox" name="rememberMe">记住我<br>
        </div>
        <div class="btn">
            <button type="submit" class="btn btn-default btn-info" style="width: 210px; height: 50px; font-size: 20px">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
        </div>
    </form>
</div>

<script>
    function refreshCode() {
        document.getElementById("verifyCode").setAttribute("src","/getCode");
    }

</script>

</body>
</html>
