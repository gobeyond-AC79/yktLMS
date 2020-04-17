package cn.imust.yktlms.service.impl;

import cn.imust.yktlms.vo.PagingVO;
import cn.imust.yktlms.entity.Student;
import cn.imust.yktlms.entity.User;
import cn.imust.yktlms.enums.RoleEnum;
import cn.imust.yktlms.enums.StatusEnum;
import cn.imust.yktlms.mapper.StudentMapper;
import cn.imust.yktlms.service.StudentService;
import cn.imust.yktlms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserService userService;

    @Override
    public void updateByStudentId(String studentId, Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public void deleteByStudentId(String studentId) {
        User user = userService.findByUserName(studentId);
        if (user != null) {
            Student student = studentMapper.selectByPrimaryKey(studentId);
            if (student.getStudentStatus().equals(StatusEnum.NORMAL_STATUS.getCode())) {
                student.setStudentStatus(StatusEnum.ERROR_STATUS.getCode());
            }
            studentMapper.updateByPrimaryKeySelective(student);
            userService.removeUser(studentId);
        }else {
            log.warn("用户不存在");
        }
    }

    @Override
    public List<Student> findByPaging(int toPageNo) {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        List<Student> studentList = studentMapper.findByPaging(pagingVO);
        return studentList;
    }

    @Override
    public Boolean saveStudent(Student student) {
        Student stu = studentMapper.selectByPrimaryKey(student.getStudentId());
        if (stu == null) {
            //设置状态
            student.setStudentStatus(StatusEnum.NORMAL_STATUS.getCode());
            studentMapper.insert(student);
            User user = new User();
            user.setUserName(student.getStudentId());
            user.setRoleId(RoleEnum.ROLE_STUDENT.getCode());
            userService.addUser(user);
            return true;
        }
        //用户名冲突应该重试
        return false;
    }

    @Override
    public Student findByStudentId(String studentId) {
        Student student = studentMapper.selectByPrimaryKey(studentId);
        if (student.getStudentStatus().equals(StatusEnum.NORMAL_STATUS.getCode())) {
            return student;
        }else{
            return null;
        }
    }

    @Override
    public int getCountStudent() {
        return studentMapper.countStudentNumber();
    }

    @Override
    public List<Student> findByStudentName(String studentName) {
        return studentMapper.selectBystudentName(studentName);
    }
}
