package cn.imust.yktlms.service.impl;

import cn.imust.yktlms.entity.Attendance;
import cn.imust.yktlms.enums.ResultEnum;
import cn.imust.yktlms.exception.YktException;
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
    public void addAttendance(String userIp,Attendance attendance) {
        boolean hasKey = redisUtil.hasKey(userIp);
        if (!hasKey) {
            redisUtil.listSet(userIp,attendance,40);
        }else{
            throw new YktException(ResultEnum.ATTENDANCE_FAIL);
        }
        attendanceMapper.updateByPrimaryKeySelective(attendance);
    }
}
