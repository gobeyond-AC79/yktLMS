package cn.imust.yktlms.controller;

import cn.imust.yktlms.dto.CourseDTO;
import cn.imust.yktlms.entity.*;
import cn.imust.yktlms.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author SERENDIPITY
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private CourseSelectionService courseSelectionService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ProblemService problemService;

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private TeacherService teacherService;

    /**
     * 课程显示
     * @param map
     * @return
     */
    @RequestMapping("/showCourse")
    public ModelAndView stuCourseShow(Map<String,Object> map) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        //先根据学生id查找出课程id
        List<String> courseIdByStudentId = courseSelectionService.findCourseIdByStudentId(user.getUserName());
        ArrayList<CourseDTO> courses = new ArrayList<>();
        //遍历课程id查找课程，并且放入一个ArrayList中
        for(String courseId : courseIdByStudentId) {
            CourseDTO courseDTO = new CourseDTO();
            Course byCourseId = courseService.findByCourseId(courseId);
            BeanUtils.copyProperties(byCourseId,courseDTO);
            courseDTO.setTeacherName(teacherService.findByTeacherId(byCourseId.getTeacherId()).getTeacherName());
            courses.add(courseDTO);
        }
        map.put("courses",courses);
        return new ModelAndView("student/showCourse",map);
    }

    /**
     * 查看课程详情
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/courseDeatil")
    public ModelAndView courseDetail(Map<String,Object> map,String courseId) {
        Course course = courseService.findByCourseId(courseId);
        map.put("course",course);
        return new ModelAndView("student/courseDetail",map);
    }

    /**
     * 查看对应课程的问题
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/showProblem")
    public ModelAndView showProblem(Map<String,Object> map,String courseId) {
        List<Problem> problemList = problemService.findProblemsByCourseId(courseId);
        map.put("problemList",problemList);
        return new ModelAndView("student/showProblem",map);
    }

    /**
     * 提问
     * @param problem
     * @return
     */
    @PostMapping("/addProblem")
    public String createProblem(Problem problem) {
        problemService.addProblem(problem);
        return "student/showProblem";
    }

    /**
     * 显示作业
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/showHomework")
    public ModelAndView showHomework(Map<String,Object> map,String courseId) {
        List<Homework> homeworkList = homeworkService.findHomeworkByCourseId(courseId);
        map.put("homeworkList",homeworkList);
        return new ModelAndView("student/showHomework");
    }

    @PostMapping("/submitHomework")
    public String submitHomework(HomeworkFiles homeworkFiles) {
        homeworkService.addHomeWorkFiles(homeworkFiles);
        return "student/showHomework";
    }

    /**
     * 本地账户密码重置
     * @return
     */
    @RequestMapping("/passwordRest")
    public String passwordRestUI() {
        return "student/passwordRest";
    }

}
