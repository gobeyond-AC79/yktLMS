package cn.imust.yktlms.service;

import cn.imust.yktlms.entity.Teacher;

import java.util.List;

/**
 * @author SERENDIPITY
 */
public interface TeacherService {

    /**
     * 分页查询教师
     * @param toPageNo
     * @return
     */
    List<Teacher> findByPaging(Integer toPageNo);

    /**
     * 根据教师工号更新信息
     * @param teacherId
     * @param teacher
     */
    void updateByTeacherId(String teacherId,Teacher teacher);

    /**
     * 删除教师信息（修改状态）
     * @param teacherId
     */
    void removeByTeacherId(String teacherId);

    /**
     * 添加教师
     * @param teacher
     * @return
     */
    Boolean addTeacher(Teacher teacher);

    /**
     * 根绝教工号查询信息
     * @param teacherId
     * @return
     */
    Teacher findByTeacherId(String teacherId);

    /**
     * 查询所有教师
     * @return
     */
    List<Teacher> findAll();

    /**
     * 查看教师总数
     * @return
     */
    int getCountTeacher();

    /**
     * 通过姓名模糊查询
     * @param teacherName
     */
    List<Teacher> findByTeacherName(String teacherName);
}
