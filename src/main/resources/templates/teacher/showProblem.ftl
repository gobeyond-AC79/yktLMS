<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>问题列表</title>
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
                        </div>
                    </div>

                    <table class="table table-bordered ">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>学生姓名</th>
                            <th>问题</th>
                            <th>回答</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list problemList as problem>
                            <tr>
                                <td>${problem.problemId}</td>
                                <td>${problem.studentName}</td>
                                <td>${problem.problemName}</td>
                                <#if problem.problemAnswer??>
                                    <td>${problem.problemAnswer}</td>
                                    <#else >
                                    <td>
                                        <button class="btn btn-default btn-xs btn-success" onclick="location.href='/teacher/answerProblem?problemId=${problem.problemId}'">回答问题</button>
                                    </td>
                                </#if>
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

    function confirmd() {
        var msg = "确定删除吗？";
        if (confirmd(msg) == true){
            return true;
        }else{
            return false;
        }
    }

    $("#sub").click(function () {
        $("#form1").submit();
    });


</script>

</body>
</html>