<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>作业列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<#include "top.ftl">

<#--主要内容content-->
<div id="page-content-wrapper">

    <div class="container">
        <div class="row" >
            <#include "lessMenu.ftl">
            <div class="col-md-10">
                <div class="panel-heading">

                    <div class="panel-heading">
                        <div class="row">
                            <h1 class="col-md-5">${course.courseName}</h1>
                            <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="" id="form1" method="post">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="请输入名称" name="findByName">
                                    <span class="input-group-addon btn" onclick="document.getElementById('form1').submit" id="sub">搜索</span>
                                </div>
                            </form>
                            <button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='/teacher/addHomework?courseId=${course.courseId}'">
                                布置作业
                                <sapn class="glyphicon glyphicon-plus"/>
                            </button>
                        </div>
                    </div>

                    <table class="table table-bordered ">
                        <thead>
                        <tr>
                            <th>作业号</th>
                            <th>作业名称</th>
                            <th>截止时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list homeworkList as homework>
                            <tr>
                                <td>${homework.homeworkId}</td>
                                <td>${homework.homeworkName}</td>
                                <td>${homework.stopTime?string('yyyy-MM-dd')}</td>
                                <td>
                                    <button class="btn btn-default btn-xs btn-success" onclick="location.href='/teacher/showHomeworkFiles?homeworkId=${homework.homeworkId}'">查看作业</button>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <div class="form-group">
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default " value="GO" onclick="location.href='/teacher/showCourse'">返回</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script>

    $("#sub").click(function () {
        $("#form1").submit();
    });


</script>

</body>
</html>