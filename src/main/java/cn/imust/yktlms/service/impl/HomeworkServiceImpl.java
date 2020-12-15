package cn.imust.yktlms.service.impl;

import cn.imust.yktlms.entity.Homework;
import cn.imust.yktlms.entity.HomeworkFiles;
import cn.imust.yktlms.mapper.HomeworkFilesMapper;
import cn.imust.yktlms.mapper.HomeworkMapper;
import cn.imust.yktlms.service.HomeworkService;
import cn.imust.yktlms.util.IdGenerateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Service
@Slf4j
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private HomeworkMapper homeworkMapper;

    @Autowired
    private HomeworkFilesMapper homeworkFilesMapper;

    @Override
    public void addHomework(Homework homework) {
        if (homework.getHomeworkId() == null) {
            homework.setHomeworkId(IdGenerateUtil.getHomeworkId());
        }
        homeworkMapper.insert(homework);
    }

    @Override
    public List<HomeworkFiles> findHomeworkFilesByHomeworkId(String homeworkId) {
        return homeworkFilesMapper.selectByhomeworkId(homeworkId);
    }

    @Override
    public HomeworkFiles findHomeworkFilesByHomeworkIdAndStudentId(String homeworkId, String studentId) {
        return homeworkFilesMapper.selectByTwoId(homeworkId,studentId);
    }

    @Override
    public void addHomeWorkFiles(HomeworkFiles homeworkFiles) {
        homeworkFilesMapper.insert(homeworkFiles);
    }

    @Override
    public void updateHomeWorkFiles(HomeworkFiles homeworkFiles) {
        homeworkFilesMapper.updateByPrimaryKeySelective(homeworkFiles);
    }

    @Override
    public List<Homework> findHomeworkByCourseId(String courseId) {
        return homeworkMapper.selectBycourseId(courseId);
    }

    @Override
    public Homework findById(String homeworkId) {
        return homeworkMapper.selectByPrimaryKey(homeworkId);
    }

}
