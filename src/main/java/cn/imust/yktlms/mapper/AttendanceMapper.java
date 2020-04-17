package cn.imust.yktlms.mapper;

import cn.imust.yktlms.entity.Attendance;
import cn.imust.yktlms.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Mapper
public interface AttendanceMapper extends MyMapper<Attendance> {

    /**
     * 根据课程查看签到信息
     * @param courseId
     * @return
     */
    List<Attendance> selectBycourseId(String courseId);

}
