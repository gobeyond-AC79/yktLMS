package cn.imust.yktlms.service;

import cn.imust.yktlms.entity.Problem;

import java.util.List;

/**
 * @author SERENDIPITY
 */
public interface ProblemService {

    /**
     * 根据课程号查看问题
     * @param courseId
     * @return
     */
    List<Problem> findProblemsByCourseId(String courseId);

    /**
     * 问题添加
     * @param problem
     */
    void addProblem(Problem problem);

    /**
     * 回答问题
     * 即更新信息
     * @param problem
     */
    void answerProblem(Problem problem);

    /**
     * 根据作业号查找
     * @param problemId
     * @return
     */
    Problem findById(int problemId);

}
