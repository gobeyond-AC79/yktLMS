<div class="col-md-2" >
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li ><a href="/teacher/thisCourseStudent?courseId=${course.courseId}">学生列表<span class="glyphicon glyphicon-user pull-right"></span></a></li>
        <li ><a href="/teacher/showProblem?courseId=${course.courseId}">问题回答<span class="badge pull-right"></span></a></li>
        <li ><a href="/teacher/showHomework?courseId=${course.courseId}">课程作业<span class="badge pull-right"></span></a></li>
        <li ><a href="/teacher/qrcode?courseId=${course.courseId}">上课签到<sapn class="glyphicon glyphicon-pushpin pull-right" /></a></li>
        <li role="presentation"><a href="/teacher/attendanceView">查看已到同学<sapn class="glyphicon glyphicon-ok pull-right" /></a></li>
    </ul>
</div>

<script src="../static/js/jquery-3.2.1.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>