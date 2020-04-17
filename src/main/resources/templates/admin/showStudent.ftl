<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学生信息列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>

<#include "top.ftl">

<#--主要内容content-->
<div id="page-content-wrapper">

    <div class="container">
        <div class="row">
            <#include "menu.ftl">
            <div class="col-md-10">
                <div class="panel-heading">

                    <div class="panel-heading">
                        <div class="row">
                            <h1 class="col-md-5">学生管理</h1>
                            <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="/admin/selectStudent" id="form1" method="post">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="请输入姓名" name="findByName">
                                    <span class="input-group-addon btn" onclick="document.getElementById('form1').submit" id="sub">搜索</span>
                                </div>
                            </form>
                            <button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='/admin/addStudent'">
                                添加学生
                                <sapn class="glyphicon glyphicon-plus"/>
                            </button>

                        </div>
                    </div>

                    <table class="table table-bordered ">
                        <thead>
                        <tr>
                            <th>学号</th>
                            <th>学生姓名</th>
                            <th>性别</th>
                            <th>出生日期</th>
                            <th>专业</th>
                            <th>学生电话</th>
                            <th>学生邮箱</th>
                            <th>置入课程</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list studentList as student>
                            <tr>
                                <td>${student.studentId}</td>
                                <td>${student.studentName}</td>
                                <td>${student.studentSex}</td>
                                <td>${student.studentBirthday?string('yyyy-MM-dd')}</td>
                                <td>${student.studentSpecialty}</td>
                                <td>${student.studentPhone}</td>
                                <td>${student.studentEmail}</td>
                                <td>
                                    <button class="btn btn-default btn-xs btn-success" onclick="location.href='/admin/addCourseToStudent?studentId=${student.studentId}'">选择课程</button>
                                </td>
                                <td>
                                    <button class="btn btn-default btn-xs btn-info" onClick="location.href='/admin/editStudent?studentId=${student.studentId}'">修改</button>
                                    <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/admin/removeStudent?studentId=${student.studentId}'">删除</button>
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
                                        <a href="/admin/showStudent?page=${pagingVO.upPageNo}">上一页</a>
                                    </li>
                                </#if>
                                <#list 1..pagingVO.getTotalCount() as index>
                                    <#if pagingVO.topageNo == index>
                                    <#else>
                                        <li>
                                            <a href="/admin/showStudent?page=${index}">${index}</a>
                                        </li>
                                    </#if>
                                </#list>
                                <#if pagingVO.topageNo gte pagingVO.getTotalCount()>
                                    <li class="disabled"><a href="#">下一页</a></li>
                                <#else>
                                    <li>
                                        <a href="/admin/showStudent?page=${pagingVO.nextPageNo}">下一页</a>
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
    $("#nav li:nth-child(2)").addClass("active");

    function confirmd() {
        var msg = "您真的确定要删除吗？！";
        if (confirm(msg)==true){
            return true;
        }else{
            return false;
        }
    };

    $("#sub").click(function () {
        $("#form1").submit();
    });

</script>

</html>

