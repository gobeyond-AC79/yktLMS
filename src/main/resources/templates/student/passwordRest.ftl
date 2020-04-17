<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>密码重置</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<#include "top.ftl">
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <#include "top.ftl">
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">重置密码</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form name="reset" class="form-horizontal" role="form" action="/passwordRest" id="editfrom" method="post" onsubmit="return check()">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">旧密码</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="oldPassword" id="inputEmail3" placeholder="请输入旧密码" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
                            <div class="col-sm-10">
                                <input type="password" name="newPassword" class="form-control" id="inputPassword3" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
                            <div class="col-sm-10">
                                <input type="password" name="newPassword2" class="form-control" id="inputPassword3" placeholder="请再次输入密码">
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
    $("#nav li:nth-child(5)").addClass("active")
    function check() {
        if (reset.oldPassword.value=="" || reset.oldPassword.value==null) {
            alert("请输入旧账户密码");
            return false;
        }
        if (reset.newPassword.value=="" || reset.newPassword.value==null) {
            alert("请输入新密码");
            return false;
        }
        if (reset.newPassword2.value=="" || reset.newPassword2.value==null) {
            alert("请再次输入新密码");
            return false;
        }
        if (reset.newPassword.value != reset.newPassword2.value) {
            alert("两次密码不一致");
            return false;
        }
    }
</script>

</html>