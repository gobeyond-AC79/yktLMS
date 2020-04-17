package cn.imust.yktlms.service.impl;

import cn.imust.yktlms.entity.Problem;
import cn.imust.yktlms.mapper.ProblemMapper;
import cn.imust.yktlms.service.ProblemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Service
@Slf4j
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public List<Problem> findProblemsByCourseId(String courseId) {
        return problemMapper.selectBycourseId(courseId);
    }

    @Override
    public void addProblem(Problem problem) {
        problemMapper.insert(problem);
    }

    @Override
    public void answerProblem(Problem problem) {
        problemMapper.updateByPrimaryKeySelective(problem);
    }

    @Override
    public Problem findById(int problemId) {
        return problemMapper.selectByPrimaryKey(problemId);
    }
}
