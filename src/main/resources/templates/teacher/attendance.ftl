<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>YKT签到</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<#include "top.ftl">
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">签到信息填写</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="" id="editfrom" method="post">
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">课程名称</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" id="inputPassword3" name="courseName" value="${course.courseName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">课程编号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" id="inputPassword3" name="courseId" value="${course.courseId}">
                            </div>
                        </div>
                        <#--<div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">学号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail3" name="studentId" placeholder="请输入学号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail3" name="studentName" placeholder="请输入姓名">
                            </div>
                        </div>-->
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">签到</button>
                            <#--<button class="btn btn-default" type="reset">重置</button>-->
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

<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.15&key=21ee8137b7fb02c26408b8915ca274eb"></script>
<script type="text/javascript">

    var map = new Amap.Map("mapContainer",{
        resizeEnable: true
    });

    map.plugin('AMap.Geolocation', function() {
        geolocation = new AMap.Geolocation({
            enableHighAccuracy: true, //是否使用高精度定位，默认:true
            timeout: 10000, //超过10秒后停止定位，默认：无穷大
            noIpLocate: 0,
            maximumAge: 0, //定位结果缓存0毫秒，默认：0
            convert: true, //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
            showButton: false, //显示定位按钮，默认：true
            buttonPosition: 'LB', //定位按钮停靠位置，默认：'LB'，左下角
            buttonOffset: new AMap.Pixel(10, 20), //定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            showMarker: false, //定位成功后在定位到的位置显示点标记，默认：true
            showCircle: false, //定位成功后用圆圈表示定位精度范围，默认：true
            panToLocation: false, //定位成功后将定位到的位置作为地图中心点，默认：true
            zoomToAccuracy: false //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
        });
        map.addControl(geolocation);
        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, 'complete', onComplete); //返回定位信息
        AMap.event.addListener(geolocation, 'error', onError); //返回定位出错信息
    });

    function onComplete(data) {
        var xcity = data.addressComponent.city //定位的城市名称
        //经纬度
        var lng = data.position.getLng()
        var lat = data.position.getLat()

        localStorage.setItem("xcity", xcity) //把定位存在localStorage，下次进入不会重新定位
        var p1 = [116.434027, 39.941037];
        var p2 = [116.461665, 39.941564];
        // 返回 p1 到 p2 间的地面距离，单位：米
        var dis = AMap.GeometryUtil.distance(p1, p2);
    }

</script>

</body>
</html>