package cn.imust.yktlms.service;

import cn.imust.yktlms.entity.Student;

import java.util.List;

/**
 * @author SERENDIPITY
 */
public interface StudentService {

    /**
     * 根据学号修改学生信息
     * @param studentId
     * @param student
     */
    void updateByStudentId (String studentId, Student student);

    /**
     * 根据学号删除学生
     * 删除操作是修改状态studentStatus
     * @param studentId
     */
    void deleteByStudentId (String studentId);

    /**
     * 获取分页查询学生信息
     * @param toPageNo
     * @return
     */
    List<Student> findByPaging ( int toPageNo);

    /**
     * 添加学生
     * @param student
     * @return
     */
    Boolean saveStudent (Student student);

    /**
     * 根据学号查询学生信息
     * @param studentId
     * @return
     */
    Student findByStudentId (String studentId);

    /**
     * 查看学生总数
     * @return
     */
    int getCountStudent();

    /**
     * 通过姓名模糊查找
     * @param studentName
     * @return
     */
    List<Student> findByStudentName(String studentName);
}