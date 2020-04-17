package cn.imust.yktlms.mapper;

import cn.imust.yktlms.entity.CourseSelection;
import cn.imust.yktlms.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Mapper
public interface CourseSelectionMapper extends MyMapper<CourseSelection> {

    /**
     * 根据课程查找
     * @param courseId
     * @return
     */
    List<CourseSelection> selectBycourseId(String courseId);

    /**
     * 根据学生查找
     * @param studentId
     * @return
     */
    List<CourseSelection> selectBystudentId(String studentId);

    void removeCourse(String studentId, String courseId);

}
