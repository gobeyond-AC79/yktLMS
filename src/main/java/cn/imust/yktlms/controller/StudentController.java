package cn.imust.yktlms.controller;

import cn.imust.yktlms.dto.CourseDTO;
import cn.imust.yktlms.dto.ProblemDTO;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author SERENDIPITY
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

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
     * 查看对应课程的问题
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/showProblem")
    public ModelAndView showProblem(Map<String,Object> map,String courseId) {
        List<Problem> problems = problemService.findProblemsByCourseId(courseId);
        Course course = courseService.findByCourseId(courseId);
        ArrayList<ProblemDTO> problemList = new ArrayList<>();
        for (Problem p:problems) {
            ProblemDTO problemDTO = new ProblemDTO();
            BeanUtils.copyProperties(p,problemDTO);
            problemDTO.setStudentName(studentService.findByStudentId(p.getStudentId()).getStudentName());
            problemList.add(problemDTO);
        }
        map.put("course",course);
        map.put("problemList",problemList);
        return new ModelAndView("student/showProblem",map);
    }

    @GetMapping("/addProblem")
    public ModelAndView createProblemUI(Map<String,Object> map,String courseId) {
        Course course = courseService.findByCourseId(courseId);
        map.put("course",course);
        return new ModelAndView("student/addProblem",map);
    }

    /**
     * 提问
     * @param problem
     * @return
     */
    @PostMapping("/addProblem")
    public ModelAndView createProblem(Map<String,Object> map,Problem problem) {
        if (problem.getStudentId() == null) {
            Subject subject = SecurityUtils.getSubject();
            User user = (User) subject.getPrincipal();
            problem.setStudentId(user.getUserName());
        }
        problemService.addProblem(problem);
        Course course = courseService.findByCourseId(problem.getCourseId());
        map.put("courseId",course.getCourseId());
        return new ModelAndView("redirect:/student/showProblem",map);
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
        Course course = courseService.findByCourseId(courseId);
        map.put("course",course);
        map.put("homeworkList",homeworkList);
        homeworkList.removeIf(c -> c.getStopTime().before(new Date()));
        return new ModelAndView("student/showHomework");
    }

    /**
     * 提交作业页面显示
     * @param map
     * @param homeworkId
     * @return
     */
    @GetMapping("/submitHomework")
    public ModelAndView submitHomeworkUI(Map<String,Object> map,String homeworkId) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Homework homework = homeworkService.findById(homeworkId);
        HomeworkFiles homeworkFiles = homeworkService.findHomeworkFilesByHomeworkIdAndStudentId(homeworkId, user.getUserName());
        map.put("homeworkFiles",homeworkFiles);
        map.put("homework",homework);
        return new ModelAndView("student/submitHomework",map);
    }

    /**
     * 提交作业
     * @param homeworkFiles
     * @return
     */
    @PostMapping("/submitHomework")
    public ModelAndView submitHomework(Map<String,Object> map,HomeworkFiles homeworkFiles) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (homeworkFiles.getStudentId() == null) {
            homeworkFiles.setStudentId(user.getUserName());
        }
        String courseId = homeworkService.findById(homeworkFiles.getHomeworkId()).getCourseId();
        if (homeworkService.findHomeworkFilesByHomeworkIdAndStudentId(homeworkFiles.getHomeworkId(),user.getUserName()) != null){
            homeworkService.updateHomeWorkFiles(homeworkFiles);
        }else{
            homeworkService.addHomeWorkFiles(homeworkFiles);
        }
        map.put("courseId",courseId);
        return new ModelAndView("redirect:/student/showHomework",map);
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
