<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>签到二维码</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <style>
        *{
            margin: 0px;
            padding: 0px;
        }
        #qrcode{
            margin: auto;
            width: 200px;
            height: 200px;
            position: fixed;
            top: 0;
            left: 0px;
            right: 0px;
            bottom: 0px;
        }
        .box-title{
            text-align: center;
            color: rgb(0, 0, 0);
        }
        .footer{
            margin: auto;
        }
    </style>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
    <h1 class="box-title">请同学们扫描二维码进行登录签到！</h1>
</div>
<div id="qrcode" ></div>
<a href="/teacher/attendanceView"><h4>已签到同学名单</h4></a>
<div class="form-group">
    <div class="form-group" style="text-align: center">
        <button class="btn btn-default " value="GO" onclick="location.href='/teacher/showCourse'">返回</button>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script>
    $('#qrcode').qrcode({
        size: 350,
        fill: '#1C1C1C',
        text: 'http://192.168.31.9:8080/teacher/attendance?courseId=${course.courseId}'
    });
</script>

</body>
</html>