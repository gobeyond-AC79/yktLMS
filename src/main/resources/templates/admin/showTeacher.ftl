<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>教师信息列表</title>
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
                            <h1 class="col-md-5">任课教师管理</h1>
                            <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="/admin/selectTeacher" id="form1" method="post">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="请输入姓名" name="findByName">
                                    <span class="input-group-addon btn" onclick="document.getElementById('form1').submit" id="sub">搜索</span>
                                </div>
                            </form>
                            <button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='/admin/addTeacher'">
                                添加教师
                                <sapn class="glyphicon glyphicon-plus"/>
                            </button>

                        </div>
                    </div>

                    <table class="table table-bordered ">
                        <thead>
                        <tr>
                            <th>教职工号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>学历</th>
                            <th>职称</th>
                            <th>电话</th>
                            <th>邮箱</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list teacherList as teacher>
                            <tr>
                                <td>${teacher.teacherId}</td>
                                <td>${teacher.teacherName}</td>
                                <td>${teacher.teacherSex}</td>
                                <td>${teacher.teacherDegree}</td>
                                <td>${teacher.teacherTitle}</td>
                                <td>${teacher.teacherPhone}</td>
                                <td>${teacher.teacherEmail}</td>
                                <td>
                                    <button class="btn btn-default btn-xs btn-info" onClick="location.href='/admin/editTeacher?teacherId=${teacher.teacherId}'">修改</button>
                                    <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/admin/removeTeacher?teacherId=${teacher.teacherId}'">删除</button>
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
                                        <a href="/admin/showTeacher?page=${pagingVO.upPageNo}">上一页</a>
                                    </li>
                                </#if>
                                <#list 1..pagingVO.getTotalCount() as index>
                                    <#if pagingVO.topageNo == index>
                                    <#else>
                                        <li>
                                            <a href="/admin/showTeacher?page=${index}">${index}</a>
                                        </li>
                                    </#if>
                                </#list>
                                <#if pagingVO.topageNo gte pagingVO.getTotalCount()>
                                    <li class="disabled"><a href="#">下一页</a></li>
                                <#else>
                                    <li>
                                        <a href="/admin/showTeacher?page=${pagingVO.nextPageNo}">下一页</a>
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

    $("#nav li:nth-child(3)").addClass("active")

    function confirmd() {
        var msg = "您真的确定要删除吗？！";
        if (confirm(msg)==true){
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

