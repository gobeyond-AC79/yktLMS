package cn.imust.yktlms.mapper;

import cn.imust.yktlms.entity.Course;
import cn.imust.yktlms.vo.PagingVO;
import cn.imust.yktlms.util.MyMapper;

import java.util.List;

/**
 * @author SERENDIPITY
 */
public interface CourseMapper extends MyMapper<Course> {

    /**
     * 分页查询课程
     * @param pagingVO
     * @return
     */
    List<Course> findByPaging(PagingVO pagingVO);

    /**
     * 根据课程名查询
     * @param courseName
     * @return
     */
    List<Course> selectBycourseName(String courseName);

    List<Course> selectByteacherId(String teacherId);

    int countCourseNumber();
}
