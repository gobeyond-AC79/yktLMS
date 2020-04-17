package cn.imust.yktlms.controller;

import cn.imust.yktlms.entity.*;
import cn.imust.yktlms.service.*;
import cn.imust.yktlms.util.IdGenerateUtil;
import cn.imust.yktlms.vo.PagingVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author SERENDIPITY
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private ProblemService problemService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private CourseSelectionService courseSelectionService;

    @Autowired
    private StudentService studentService;

    /**
     * 课程显示
     * @param map
     * @return
     */
    @RequestMapping("/showCourse")
    public ModelAndView teaCourseShow(Map<String,Object> map) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        PagingVO pagingVO = new PagingVO();
        List<Course> teaCourse = courseService.findByTeacherId(user.getUserName());
        map.put("teaCourse",teaCourse);
        return new ModelAndView("teacher/showCourse",map);
    }

    /**
     * 搜索课程
     * @param courseName
     * @param map
     * @return
     */
    @RequestMapping("/selectCourse")
    private ModelAndView selectCourse(String courseName,Map<String,Object> map) {
        List<Course> courseList = courseService.findByCourseName(courseName);
        //TODO 没找到的错误信息
        map.put("courseList",courseList);
        return new ModelAndView("teacher/showCourse",map);
    }

    /**
     * 课程详情页面中的课程信息
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/courseDetail")
    public ModelAndView courseDetail(Map<String,Object> map,String courseId) {
        Course course = courseService.findByCourseId(courseId);
        map.put("course",course);
        return new ModelAndView("teacher/courseDetail",map);
    }

    /**
     * 当前课程的学生
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/thisCourseStudent")
    public ModelAndView thisCourseStudent(Map<String,Object> map,String courseId) {
        List<String> studentIds = courseSelectionService.findStudentIdByCourseId(courseId);
        ArrayList<Student> studentList = new ArrayList<>();
        for (String studentId :studentIds) {
            studentList.add(studentService.findByStudentId(studentId));
        }
        map.put("studentList",studentList);
        return new ModelAndView("teacher/thisCourseStudent",map);
    }

    /**
     * 查看问题
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/showProblem")
    public ModelAndView showProblem (Map<String ,Object> map, String courseId) {
        List<Problem> problemList = problemService.findProblemsByCourseId(courseId);
        map.put("problemList",problemList);
        return new ModelAndView("teacher/showProblem",map);
    }

    /**
     * 回答问题
     * @param problem
     * @return
     */
    @PostMapping("answerProblem")
    public String answerProblem(Problem problem) {
        problemService.answerProblem(problem);
        return "teacher/showProblem";
    }

    /**
     * 查看作业
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/showHomework")
    public ModelAndView showHomework(Map<String,Object> map,String courseId) {
        List<Homework> homeworkList = homeworkService.findHomeworkByCourseId(courseId);
        map.put("homeworkList",homeworkList);
        return new ModelAndView("teacher/showHomework");
    }

    /**
     * 布置作业
     * @param homework
     * @return
     */
    @PostMapping("/addHomework")
    public String addHomework(Homework homework) {
        if (homework.getHomeworkId() == null) {
            homework.setHomeworkId(IdGenerateUtil.getHomeworkId());
        }
        homeworkService.addHomework(homework);
        return "teacher/showHomework";
    }

    @PostMapping("/attendance")
    public void addAttendance(HttpServletRequest request, Attendance attendance) {
        //没有使用反向代理的情况
        String serverIp = request.getServerName();
        String userIp = request.getRemoteAddr();
        attendanceService.addAttendance(userIp,attendance);
    }

    /**
     * 查看一个课程学生的签到情况
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/attendanceView")
    public ModelAndView thisCourseAttendance(Map<String,Object> map,String courseId) {
        List<Attendance> attendanceView = attendanceService.findAllByCourseId(courseId);
        map.put("attendanceView",attendanceView);
        return new ModelAndView("teacher/attendanceView",map);
    }

    /**
     * 本地账户密码重置
     * @return
     */
    @RequestMapping("/passwordRest")
    public String passwordRestUI() {
        return "teacher/passwordRest";
    }

}
