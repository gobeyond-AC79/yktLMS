<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>课程信息列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<#include "top.ftl">
<#--<script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.min.js"></script>-->

<#--<script src="../static/js/jquery-3.2.1.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>-->

<#--主要内容content-->
<div id="page-content-wrapper">

    <div class="container">
        <div class="row" >
            <#include "menu.ftl">
            <div class="col-md-10">
                <div class="panel-heading">

                    <div class="panel-heading">
                        <div class="row">
                            <h1 class="col-md-5">课程管理</h1>
                            <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="/admin/selectCourse" id="form1" method="post">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="请输入名称" name="findByName">
                                    <span class="input-group-addon btn" onclick="document.getElementById('form1').submit" id="sub">搜索</span>
                                </div>
                            </form>
                            <button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='/admin/addCourse'">
                                添加课程信息
                                <sapn class="glyphicon glyphicon-plus"/>
                            </button>

                        </div>
                    </div>

                    <table class="table table-bordered ">
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
                        <#list coursesList as course>
                            <tr>
                                <td>${course.courseId}</td>
                                <td>${course.courseName}</td>
                                <td>${course.teacherName}</td>
                                <td>${course.courseTime}分钟</td>
                                <td>${course.courseLocal}</td>
                                <td>${course.courseWeek}</td>
                                <td>${course.courseType}</td>
                                <td>${course.courseSore}</td>
                                <td>
                                    <button class="btn btn-default btn-xs btn-info" onClick="location.href='/admin/editCourse?courseId=${course.courseId}'">修改</button>
                                    <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/admin/removeCourse?courseId=${course.courseId}'">删除</button>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <div class="panel-footer">
                        <nav style="text-align: center">
                            <ul class="pagination">
                                <#if pagingVO.topageNo lte 1>
                                    <li class = "disabled"><a href="#">上一页</a></li>
                                    <#else>
                                    <li>
                                        <a href="/admin/showCourse?page=${pagingVO.upPageNo}">上一页</a>
                                    </li>
                                </#if>
                                <#list 1..pagingVO.getTotalCount() as index>
                                    <#if pagingVO.topageNo == index>
                                        <#else>
                                        <li>
                                            <a href="/admin/showCourse?page=${index}">${index}</a>
                                        </li>
                                    </#if>
                                </#list>
                                <#if pagingVO.topageNo gte pagingVO.getTotalCount()>
                                    <li class="disabled"><a href="#">下一页</a></li>
                                    <#else>
                                    <li>
                                        <a href="/admin/showCourse?page=${pagingVO.nextPageNo}">下一页</a>
                                    </li>
                                </#if>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

</body>

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

</html>

