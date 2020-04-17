<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>添加学生信息</title>
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
                        <h1 style="text-align: center;">添加学生信息</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/admin/addStudent" id="editfrom" method="post">
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputPassword3" name="studentName" placeholder="请输入姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label class="checkbox-inline">
                                    <input type="radio" name="studentSex" value="男" checked>男
                                </label>
                                <label class="checkbox-inline">
                                    <input type="radio" name="studentSex" value="女">女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">出生年份</label>
                            <div class="col-sm-10">
                                <input type="date" value="1996-09-02" name="studentBirthday"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="studentSpecialty">所属专业</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="studentSpecialty">
                                    <option value="计算机科学与技术">计算机科学与技术</option>
                                    <option value="软件工程">软件工程</option>
                                    <option value="通信工程">通信工程</option>
                                    <option value="电气工程及自动化">电气工程及自动化</option>
                                    <option value="电子信息技术">电子信息技术</option>
                                    <option value="土木工程">土木工程</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">手机号</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="inputEmail3" name="studentPhone" placeholder="请输入手机号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail3" name="studentEmail" placeholder="请输入邮箱">
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                            <button class="btn btn-default" type="reset">重置</button>
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
</html>