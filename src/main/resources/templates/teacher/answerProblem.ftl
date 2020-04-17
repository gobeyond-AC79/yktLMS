<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>回答问题</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<#include "top.ftl">
<div class="container" id="content">
    <div class="row">
        <#--<#include "lessMenu.ftl">-->
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">问题回答</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/teacher/answerProblem" id="editfrom" method="post">
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="grade">序号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" name="problemId" value="${problem.problemId}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="grade">课程号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" name="courseId" value="${problem.courseId}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="grade">问题</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" name="problemName" value="${problem.problemName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="grade">学生学号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" name="studentId" value="${problem.studentId}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="grade">学生姓名</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" name="studentName" value="${problemDTO.studentName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="grade"></label>
                            <div class="col-sm-10">
                                <textarea class="form-control" rows="4" name="problemAnswer"></textarea>
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

</body>
</html>