<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户密码重置</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<#include "top.ftl">
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <#include "menu.ftl">
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">重置其他用户密码</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" name="reset" role="form" action="/admin/userPasswordRest" id="editfrom" method="post" onsubmit="return check()">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">账号(非管理员账号)</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="userName" id="inputEmail3" placeholder="请输入用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="userPassword" placeholder="请输入密码" name="userPassword">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="userPassword2" id="inputPassword3" placeholder="请再次输入密码">
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                            <button class="btn btn-default">重置</button>
                        </div>
                    </form>
                </div>

            </div>

        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>
</body>

<script>
    $("#nav li:nth-child(4)").addClass("active")
    function check() {
        if (reset.userName.value=="" || reset.userName.value==null) {
            alert("请输入用户名");
            return false;
        }
        if (reset.userPassword.value=="" || reset.userPassword.value==null) {
            alert("请输入新密码");
            return false;
        }
        if (reset.userPassword2.value=="" || reset.userPassword2.value==null) {
            alert("请再次输入新密码");
            return false;
        }
        if (reset.userPassword.value != reset.userPassword2.value) {
            alert("两次密码不一致");
            return false;
        }
    }
</script>

</html>