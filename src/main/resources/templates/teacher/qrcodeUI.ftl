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
            width: 200px;
            height: 200px;
            position: fixed;
            top: 0px;
            left: 0px;
            right: 0px;
            bottom: 0px;
            margin: auto;
        }
    </style>
</head>
<body>

<div id="qrcode" ></div>
<script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script>
    $('#qrcode').qrcode({
        size: 350,
        fill: '#1C1C1C',
        text: 'http://192.168.1.7:8080/teacher/attendance?courseId=${course.courseId}'
    });
</script>

</body>
</html>