<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>查看我的作业</title>
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
                        <h1 style="text-align: center;">查看当前课程作业</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/student/submitHomework" id="editfrom" method="post">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">作业标题</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" id="inputEmail3" value="${homework.homeworkName}" name="homeworkName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">作业号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" value="${homework.homeworkId}" id="inputEmail3" name="homeworkId">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputFile" class="col-sm-2 control-label">书写内容</label>
                            <div class="col-sm-10" id="editor">
                                <#if (homeworkFiles.homeworkFile)??>
                                    ${homeworkFiles.homeworkFile}
                                    <#--<input type="file" id="exampleInputFile" class="form-control" value="${homeworkFiles.homeworkFile}" />-->
                                    <#else >
                                        <#--<input type="file" id="exampleInputFile" name="homeworkFile" />-->
                                        <textarea style="display: none" name="homeworkFile" id="txtIntro"></textarea>
                                </#if>
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                            <button class="btn btn-default" type="reset">重置</button>
                        </div>
                    </form>
                </div>
                <div style="text-align: right">
                    <button class="btn btn-default " value="GO" onclick="location.href='/student/showHomework?courseId=${homework.courseId}'">返回作业列表</button>
                </div>
            </div>

        </div>
    </div>
</div>

<script src="../static/js/jquery-3.2.1.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/wangeditor@3.1.1/release/wangEditor.min.js"></script>
<script>
    var E = window.wangEditor;
    var editor = new E("#editor");
    //获取隐藏控件textarea的id，用于数据显示，方便后台获取内容
    var text = $("#txtIntro");
    //监控wangEditor中内容的变化，并同步更新到textarea
    editor.customConfig.onchange = function (html) {
        text.val(html);
    }
    //editor.customConfig.uploadImgServer = "/myFile";
    editor.customConfig.showLinkImg = false;
    //editor.customConfig. uploadImgShowBase64 = true;
    editor.create();
    //text.val(editor2.text.html());//初始化textarea的值
</script>

</body>
</html>