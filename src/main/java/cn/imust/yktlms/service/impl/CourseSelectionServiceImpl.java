package cn.imust.yktlms.service.impl;

import cn.imust.yktlms.entity.CourseSelection;
import cn.imust.yktlms.mapper.CourseSelectionMapper;
import cn.imust.yktlms.service.CourseSelectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SERENDIPITY
 */
@Service
@Slf4j
public class CourseSelectionServiceImpl implements CourseSelectionService {

    @Autowired
    private CourseSelectionMapper courseSelectionMapper;


    @Override
    public List<String> findStudentIdByCourseId(String courseId) {
        List<CourseSelection> courseSelections = courseSelectionMapper.selectBycourseId(courseId);
        List<String> studentIdList = new LinkedList<>();
        for (CourseSelection courseSelection:courseSelections) {
            String studentId = courseSelection.getStudentId();
            studentIdList.add(studentId);
        }
        return studentIdList;
    }

    @Override
    public List<String> findCourseIdByStudentId(String studentId) {
        List<CourseSelection> courseSelections = courseSelectionMapper.selectBystudentId(studentId);
        List<String> courseList = new LinkedList<> ();
        for (CourseSelection courseSelection:courseSelections) {
            String courseId = courseSelection.getCourseId();
            courseList.add(courseId);
        }
        return courseList;
    }

    @Override
    public void addCourseToStudent(String courseId, String studentId) {
        CourseSelection courseSelection = new CourseSelection();
        courseSelection.setCourseId(courseId);
        courseSelection.setStudentId(studentId);
        courseSelectionMapper.insert(courseSelection);

    }

    @Override
    public void removeCourseToStudent(String studentId, String courseId) {
        courseSelectionMapper.removeCourse(studentId,courseId);
    }
}
