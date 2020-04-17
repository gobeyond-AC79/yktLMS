package cn.imust.yktlms.service;

import cn.imust.yktlms.entity.Homework;
import cn.imust.yktlms.entity.HomeworkFiles;

import java.util.List;

/**
 * @author SERENDIPITY
 */
public interface HomeworkService {

    /**
     * 布置作业
     * @param homework
     */
    void addHomework(Homework homework);

    /**
     * 同过作业号查找具体作业提交文件
     * @param homeworkId
     * @return
     */
    List<HomeworkFiles> findHomeworkFilesByHomeworkId(String homeworkId);

    /**
     * 提交作业
     * @param homeworkFiles
     */
    void addHomeWorkFiles(HomeworkFiles homeworkFiles);

    /**
     * 通过课程号找到对应的作业
     * @param courseId
     * @return
     */
    List<Homework> findHomeworkByCourseId(String courseId);

}
