package cn.imust.yktlms.service.impl;

import cn.imust.yktlms.entity.Course;
import cn.imust.yktlms.vo.PagingVO;
import cn.imust.yktlms.enums.StatusEnum;
import cn.imust.yktlms.mapper.CourseMapper;
import cn.imust.yktlms.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findByPaging(Integer toPageNo) {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        return courseMapper.findByPaging(pagingVO);
    }

    @Override
    public void updateByCourseId(String courseId, Course course) {
        courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public Boolean removeCourseByCourseId(String courseId) {
        Course course = courseMapper.selectByPrimaryKey(courseId);
        if (course.getCourseStatus().equals(StatusEnum.NORMAL_STATUS.getCode())) {
            course.setTeacherId(null);
            course.setCourseStatus(StatusEnum.ERROR_STATUS.getCode());
            courseMapper.updateByPrimaryKey(course);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean addCourse(Course course) {
        Course cou = courseMapper.selectByPrimaryKey(course.getCourseId());
        if (cou == null) {
            course.setCourseStatus(StatusEnum.NORMAL_STATUS.getCode());
            courseMapper.insert(course);
            return true;
        }
        return false;
    }

    @Override
    public Course findByCourseId(String courseId) {
        Course course = courseMapper.selectByPrimaryKey(courseId);
        if (course.getCourseStatus().equals(StatusEnum.NORMAL_STATUS.getCode())) {
            return course;
        }else {
            return null;
        }
    }

    @Override
    public int getCountCourse() {
        return courseMapper.countCourseNumber();
    }

    @Override
    public List<Course> findByCourseName(String courseName) {
        return courseMapper.selectBycourseName(courseName);
    }

    @Override
    public List<Course> findByTeacherId(String teacherId) {
        return courseMapper.selectByteacherId(teacherId);
    }

    @Override
    public List<Course> findAll() {
        //return courseMapper.selectAll();
        return courseMapper.selectAllCourse();
    }

}