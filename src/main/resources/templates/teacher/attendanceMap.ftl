<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学生签到情况</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/echarts/4.8.0/echarts.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <style>
        .box-title{
            text-align: center;
            color: rgb(0,255,234);
        }
        #attendance_chart{
            margin: auto;
            width: 800px;
            height: 400px;
            border: 1px black solid;
        }
        .btn{

        }
    </style>
</head>
<body>
<#include "top.ftl">
<div id="page-content-wrapper">
    <div class="container">
        <div class="row" >
            <#include "lessMenu.ftl">
            <div class="col-md-10">
                <div id="header">
                    <h3 class="box-title">学生签到情况图</h3>
                </div>
                <div id="attendance_chart"></div>
            </div>
        </div>
    </div>
</div>
<script>
    var attendanceChart = echarts.init(document.getElementById('attendance_chart'));
    var option = {
        legend: {
            data: ['签到次数']
        },
        tooltip: {},
        xAxis: {
            data: []
        },
        yAxis: {
        },
        series: [{
            name: '签到次数',
            type: 'bar',
            data: []
        }]
    };
    attendanceChart.setOption(option);
    var names = [];
    var nums = [];
    <#list attendanceList as attendance>
        names.push("${attendance.studentName}");
        nums.push(${attendance.attendanceNumber});
    </#list>
    attendanceChart.setOption({
        xAxis: {
          data: names
        },
        series: [{
            name: '签到次数',
            data: nums
        }]
    });
</script>
</body>
</html>