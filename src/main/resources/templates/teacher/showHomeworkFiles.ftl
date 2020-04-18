<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>查看作业文件</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<#include "top.ftl">

<#--主要内容content-->
<div id="page-content-wrapper">

    <div class="container">
        <div class="row" >
            <div class="col-md-12">
                <div class="panel-heading">

                    <div class="panel-heading">
                        <div class="row">
                            <h1 class="col-md-5">${homework.homeworkName}</h1>
                        </div>
                    </div>

                    <table class="table table-bordered ">
                        <thead>
                        <tr>
                            <th>学生姓名</th>
                            <th>作业</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list homeworkFilesList as homeworkFiles>
                            <tr>
                                <td>${homeworkFiles.studentName}</td>
                                <td>${homework.homeworkName}</td>
                                <td>
                                    <button class="btn btn-default btn-xs btn-success" onclick="location.href=''">下载</button>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <div class="form-group">
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default " value="GO" onclick="location.href='/teacher/showHomework?courseId=${homework.courseId}'">返回</button>
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