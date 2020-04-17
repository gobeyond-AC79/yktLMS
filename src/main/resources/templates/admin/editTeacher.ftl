<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>修改教师信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.2.1.min.js"></script>
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
                        <h1 style="text-align: center;">修改教师信息</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/admin/editTeacher" id="editfrom" method="post">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">教职工号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" id="inputEmail3" name="teacherId"  value="${teacher.teacherId}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputPassword3" name="teacherName" value="${teacher.teacherName}" placeholder="请输入姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label class="checkbox-inline">
                                    <input type="radio" name="teacherSex" value="男" checked>男
                                </label>
                                <label class="checkbox-inline">
                                    <input type="radio" name="teacherSex" value="女">女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">出生年份</label>
                            <div class="col-sm-10">
                                <input type="date" value="${teacher.teacherBirthday?string('yyyy-MM-dd')}" name="teacherBirthday" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="teacherDegree">学历：</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="teacherDegree">
                                    <option value="本科">本科</option>
                                    <option value="硕士">硕士</option>
                                    <option value="博士">博士</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="teacherTitle">职称：</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="teacherTitle">
                                    <option value="普通教师">普通教师</option>
                                    <option value="助教">助教</option>
                                    <option value="讲师">讲师</option>
                                    <option value="副教授">副教授</option>
                                    <option value="教授">教授</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">手机号</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="inputEmail3" name="teacherPhone" value="${teacher.teacherPhone}" placeholder="请输入手机号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail3" name="teacherEmail" value="${teacher.teacherEmail}" placeholder="请输入邮箱">
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

<script>
    $("#nav li:nth-child(3)").addClass("active");

    var teacherDegreeSelect = $("#teacherDegree option");
    for (var i=0; i<teacherDegreeSelect.length; i++) {
        if (teacherDegreeSelect[i].value == '${teacher.teacherDegree}') {
            teacherDegreeSelect[i].selected = true;
        }
    }

    var teacherTitleSelect = $("#teacherTitle option");
    for (var i=0; i<teacherTitleSelect.length; i++) {
        if (teacherTitleSelect[i].value == '${teacher.teacherTitle}') {
            teacherTitleSelect[i].selected = true;
        }
    }

</script>

</html>