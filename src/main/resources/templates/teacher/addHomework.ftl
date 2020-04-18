<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>布置作业</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<#include "top.ftl">
<div class="container" id="content">
    <div class="row">
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">布置作业</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/teacher/addHomework" id="editfrom" method="post">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">课程名称</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" id="inputEmail3" value="${course.courseName}" name="courseName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">课程号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" value="${course.courseId}" id="inputEmail3" name="courseId">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">作业标题</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail3" name="homeworkName" placeholder="请输入作业标题">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">截止时间</label>
                            <div class="col-sm-10">
                                <input type="date" value="2020-04-05" name="stopTime"/>
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