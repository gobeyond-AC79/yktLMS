package cn.imust.yktlms.service;

import cn.imust.yktlms.entity.Attendance;

import java.util.List;

/**
 * @author SERENDIPITY
 */
public interface AttendanceService {

    /**
     * 根据课程查看学生签到列表
     * @param courseId
     * @return
     */
    List<Attendance> findAllByCourseId(String courseId);

    /**
     * 记录签到信息
     * @param userIp
     * @param attendance
     */
    void addAttendance(String userIp,Attendance attendance);

}
