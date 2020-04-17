package cn.imust.yktlms.service;

import cn.imust.yktlms.entity.CourseSelection;

import java.util.List;

/**
 * @author SERENDIPITY
 */
public interface CourseSelectionService {

    /**
     * 通过课程号查找对应学生学号
     * @param courseId
     * @return
     */
    List<String> findStudentIdByCourseId(String courseId);

    /**
     * 通过学号查找对应课程号
     * @param studentId
     * @return
     */
    List<String> findCourseIdByStudentId(String studentId);

    /**
     * 为课程添加学生
     * @param courseId
     * @param studentId
     */
    void addCourseToStudent(String courseId,String studentId);

    /**
     * 取消选课
     * @param courseId
     * @param studentId
     */
    void removeCourseToStudent(String courseId,String studentId);

}
