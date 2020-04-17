<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>添加课程信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<#include "top.ftl">
<div class="container" id="content">
    <div class="row">
        <#include "menu.ftl">
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">添加课程信息</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/admin/addCourse" id="editfrom" method="post">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">课程名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail3" name="courseName" placeholder="请输入课程名称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="grade">授课老师</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="teacherId">
                                    <#list teacherList as teacher>
                                        <option value="${teacher.teacherId}">${teacher.teacherName}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">课程时间</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="inputPassword3" name="courseTime" placeholder="请输入课程时间">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">上课地点</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="courseLocal" placeholder="请输入上课地点">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">课程周数</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="courseWeek" placeholder="请输入课程周数">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="courseType">课程的类型：</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="courseType">
                                    <option value="必修课">必修课</option>
                                    <option value="选修课">选修课</option>
                                    <option value="公共课">公共课</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">学分</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="courseSore" placeholder="请输入学分">
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