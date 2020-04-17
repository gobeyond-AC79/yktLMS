package cn.imust.yktlms.service.impl;

import cn.imust.yktlms.vo.PagingVO;
import cn.imust.yktlms.entity.Teacher;
import cn.imust.yktlms.entity.User;
import cn.imust.yktlms.enums.RoleEnum;
import cn.imust.yktlms.enums.StatusEnum;
import cn.imust.yktlms.mapper.TeacherMapper;
import cn.imust.yktlms.service.TeacherService;
import cn.imust.yktlms.service.UserService;
import com.alibaba.druid.support.spring.stat.annotation.Stat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<Teacher> findByPaging(Integer toPageNo) {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        List<Teacher> teacherList = teacherMapper.findByPaging(pagingVO);
        return teacherList;
    }

    @Override
    public void updateByTeacherId(String teacherId, Teacher teacher) {
        teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    @Override
    public void removeByTeacherId(String teacherId) {
        User user = userService.findByUserName(teacherId);
        if (user != null) {
            Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
            if (teacher.getTeacherStatus().equals(StatusEnum.NORMAL_STATUS.getCode())) {
                teacher.setTeacherStatus(StatusEnum.ERROR_STATUS.getCode());
            }
            teacherMapper.updateByPrimaryKeySelective(teacher);
            userService.removeUser(teacherId);
        }else {
            log.warn("用户不存在");
        }
    }

    @Override
    public Boolean addTeacher(Teacher teacher) {
        Teacher tea = teacherMapper.selectByPrimaryKey(teacher.getTeacherId());
        if (tea == null) {
            teacher.setTeacherStatus(StatusEnum.NORMAL_STATUS.getCode());
            teacherMapper.insert(teacher);
            User user = new User();
            user.setUserName(teacher.getTeacherId());
            user.setRoleId(RoleEnum.ROLE_TEACHER.getCode());
            userService.addUser(user);
            return true;
        }
        return false;
    }

    @Override
    public Teacher findByTeacherId(String teacherId) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
        if (teacher .getTeacherStatus().equals(StatusEnum.NORMAL_STATUS.getCode())) {
            return teacher;
        }
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public int getCountTeacher() {
        return teacherMapper.countTeacherNumber();
    }

    @Override
    public List<Teacher> findByTeacherName(String teacherName) {
        return teacherMapper.findByTeacherName(teacherName);
    }
}