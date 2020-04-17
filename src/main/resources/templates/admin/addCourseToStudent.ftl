<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>置入课程</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
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
                        <h1 style="text-align: center;">课程置入</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <h3>已选课程</h3>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>课程号</th>
                            <th>课程名称</th>
                            <th>任课教师</th>
                            <th>课程时间</th>
                            <th>课程地点</th>
                            <th>周数</th>
                            <th>课程类型</th>
                            <th>学分</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list courseSelectedList as courseSelectedList>
                            <tr>
                                <td>${courseSelectedList.courseId}</td>
                                <td>${courseSelectedList.courseName}</td>
                                <td>${courseSelectedList.teacherName}</td>
                                <td>${courseSelectedList.courseTime}分钟</td>
                                <td>${courseSelectedList.courseLocal}</td>
                                <td>${courseSelectedList.courseWeek}</td>
                                <td>${courseSelectedList.courseType}</td>
                                <td>${courseSelectedList.courseSore}</td>
                                <td>
                                    <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/admin/removeCourseToStudent?studentId=${student.studentId}&courseId=${courseSelectedList.courseId}'">删除</button>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <form role="form" role="form" action="/admin/addCourseToStudent" id="addform" method="post">
                        <div class="form-group">
                            <div class="col-sm-12">
                                <h3>学生姓名：${student.studentName}</h3>
                                    <input readonly="readonly" type="text" class="form-control" value="${student.studentId}" name="studentId"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <label for="inputCourse" class="col-sm-2 control-label">选择课程</label>
                                    <select class="form-control col-sm-10" name="courseId">
                                        <#list courseList as course>
                                            <option value="${course.courseId}">${course.courseName}</option>
                                        </#list>
                                    </select>
                            </div>
                            <div class="form-group" style="text-align: center">
                                <button class="btn btn-default btn-success" type="submit">添加</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>

        </div>

    </div>
</div>
</body>
</html>