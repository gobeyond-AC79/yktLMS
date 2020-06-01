package cn.imust.yktlms.service.impl;

import cn.imust.yktlms.entity.Attendance;
import cn.imust.yktlms.mapper.AttendanceMapper;
import cn.imust.yktlms.service.AttendanceService;
import cn.imust.yktlms.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Service
@Slf4j
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Attendance> findAllByCourseId(String courseId) {
        return attendanceMapper.selectBycourseId(courseId);
    }

    @Override
    public void addAttendance(Attendance attendance){
        //这块放到前端返回错误页面

        Attendance a = attendanceMapper.selectBycourseIdAndStudentId(attendance.getCourseId(), attendance.getStudentId());
        if (a != null) {
            a.setAttendanceNumber(a.getAttendanceNumber()+1);
            attendanceMapper.updateByPrimaryKeySelective(a);
        }else {
            attendance.setAttendanceNumber(1);
            attendanceMapper.insert(attendance);
        }

    }

    @Override
    public void deleteAttendance(String courseId, String studentId) {
        Attendance attendance = attendanceMapper.selectBycourseIdAndStudentId(courseId, studentId);
        attendanceMapper.delete(attendance);
    }
}
