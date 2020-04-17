package cn.imust.yktlms.service;

import cn.imust.yktlms.entity.Course;
import cn.imust.yktlms.entity.Homework;

import java.util.List;

/**
 * @author SERENDIPITY
 */
public interface CourseService {

    /**
     * 分页查询课程
     * @param toPageNo
     * @return
     */
    List<Course> findByPaging(Integer toPageNo);

    /**
     * 更新课程信息
     * @param courseId
     * @param course
     */
    void updateByCourseId(String courseId,Course course);

    /**
     * 移除课程（修改状态）
     * @param courseId
     * @return
     */
    Boolean removeCourseByCourseId(String courseId);

    /**
     * 添加课程
     * @param course
     * @return
     */
    Boolean addCourse(Course course);

    /**
     * 根据课程号查找课程
     * @param courseId
     * @return
     */
    Course findByCourseId(String courseId);

    /**
     * 获取课程总数
     * @return
     */
    int getCountCourse();

    /**
     * 根据课程名查找
     * @param courseName
     * @return
     */
    List<Course> findByCourseName(String courseName);

    /**
     * 根绝教师工号查找
     * @param teacherId
     * @return
     */
    List<Course> findByTeacherId(String teacherId);

    /**
     * 查找所有课程（不分页）
     * @return
     */
    List<Course> findAll();

}
