package cn.imust.yktlms.controller;

import cn.imust.yktlms.dto.HomeworkFilesDTO;
import cn.imust.yktlms.dto.ProblemDTO;
import cn.imust.yktlms.entity.*;
import cn.imust.yktlms.service.*;
import cn.imust.yktlms.util.IdGenerateUtil;
import cn.imust.yktlms.util.RedisUtil;
import cn.imust.yktlms.vo.PagingVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private RedisUtil redisUtil;

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
        Course course = courseService.findByCourseId(courseId);
        map.put("course",course);
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
        List<Problem> problems = problemService.findProblemsByCourseId(courseId);
        Course course = courseService.findByCourseId(courseId);
        map.put("course",course);
        ArrayList<ProblemDTO> problemList = new ArrayList<>();
        for (Problem p:problems) {
            ProblemDTO problemDTO = new ProblemDTO();
            BeanUtils.copyProperties(p,problemDTO);
            problemDTO.setStudentName(studentService.findByStudentId(p.getStudentId()).getStudentName());
            problemList.add(problemDTO);
        }
        map.put("problemList",problemList);
        return new ModelAndView("teacher/showProblem",map);
    }

    /**
     * 回答问题界面
     * @param map
     * @param problemId
     * @return
     */
    @GetMapping("/answerProblem")
    public ModelAndView answerProblemUI (Map<String ,Object> map, int problemId) {
        Problem problem = problemService.findById(problemId);
        ProblemDTO problemDTO = new ProblemDTO();
        BeanUtils.copyProperties(problem,problemDTO);
        problemDTO.setStudentName(studentService.findByStudentId(problem.getStudentId()).getStudentName());
        map.put("problem",problem);
        map.put("problemDTO",problemDTO);
        return new ModelAndView("teacher/answerProblem",map);
    }

    /**
     * 回答问题
     * @param problem
     * @return
     */
    @PostMapping("answerProblem")
    public ModelAndView answerProblem(Map<String, Object> map, Problem problem) {

        problemService.answerProblem(problem);
        Course course = courseService.findByCourseId(problem.getCourseId());
        map.put("course",course);
        map.put("courseId",course.getCourseId());
        return new ModelAndView("redirect:/teacher/showProblem",map);
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
        Course course = courseService.findByCourseId(courseId);
        map.put("course",course);
        map.put("homeworkList",homeworkList);
        return new ModelAndView("teacher/showHomework",map);
    }

    /**
     * 查看提交的作业
     * @param map
     * @param homeworkId
     * @return
     */
    @GetMapping("/showHomeworkFiles")
    public ModelAndView showHomeworkFiles(Map<String,Object> map,String homeworkId) {
        List<HomeworkFiles> homeworkFiles = homeworkService.findHomeworkFilesByHomeworkId(homeworkId);
        Homework homework = homeworkService.findById(homeworkId);
        ArrayList<HomeworkFilesDTO> homeworkFilesList = new ArrayList<>();
        for (HomeworkFiles h:homeworkFiles) {
            HomeworkFilesDTO homeworkFilesDTO = new HomeworkFilesDTO();
            BeanUtils.copyProperties(h,homeworkFilesDTO);
            homeworkFilesDTO.setStudentName(studentService.findByStudentId(h.getStudentId()).getStudentName());
            homeworkFilesList.add(homeworkFilesDTO);
        }
        map.put("homework",homework);
        map.put("homeworkFilesList",homeworkFilesList);
        return new ModelAndView("teacher/showHomeworkFiles",map);
    }

    /**
     * 布置作业页面
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/addHomework")
    public ModelAndView addHomeworkUI(Map<String,Object> map,String courseId) {
        Course course = courseService.findByCourseId(courseId);
        map.put("course",course);
        return new ModelAndView("/teacher/addHomework",map);
    }

    /**
     * 布置作业
     * @param homework
     * @return
     */
    @PostMapping("/addHomework")
    public ModelAndView addHomework(Map<String,Object> map,Homework homework) {
        if (homework.getHomeworkId() == null) {
            homework.setHomeworkId(IdGenerateUtil.getHomeworkId());
        }
        homeworkService.addHomework(homework);
        String courseId = courseService.findByCourseId(homework.getCourseId()).getCourseId();
        map.put("courseId",courseId);
        return new ModelAndView("redirect:/teacher/showHomework",map);
    }

    /**
     * 渲染二维码
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/qrcode")
    public ModelAndView qrcodeUI(Map<String,Object> map,String courseId) {
        Course course = courseService.findByCourseId(courseId);
        map.put("course",course);
        return new ModelAndView("/teacher/qrcodeUI",map);
    }

    /**
     * 签到页面显示
     * @param map
     * @param courseId
     * @return
     */
    @GetMapping("/attendance")
    public ModelAndView addAttendanceUI(Map<String,Object> map,String courseId) {
        Course course = courseService.findByCourseId(courseId);
        map.put("course",course);
        return new ModelAndView("/teacher/attendance",map);
    }

    /**
     * 签到
     * @param request
     * @param attendance
     */
    @PostMapping("/attendance")
    public ModelAndView addAttendance(HttpServletRequest request, Attendance attendance,Map<String,Object> map) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Student student = studentService.findByStudentId(user.getUserName());
        attendance.setStudentId(student.getStudentId());
        attendance.setStudentName(student.getStudentName());
        //没有使用反向代理的情况
        String serverIp = request.getServerName();
        String userIp = request.getRemoteAddr();
        boolean hasKey = redisUtil.hasKey(userIp);
        if (!hasKey) {
            redisUtil.stringSet(userIp,attendance,40);
        }else{
            map.put("message","该设备已经签到过了！");
            return new ModelAndView("/common/error",map);
        }
        attendanceService.addAttendance(attendance);
        return new ModelAndView("/common/success");
    }

    /**
     * 查看当前课程哪些学生签到
     * 需要修改
     * @param map
     * @return
     */
    @GetMapping("/attendanceView")
    public ModelAndView thisCourseAttendance(Map<String,Object> map) {
        List<Attendance> attendanceRedis = redisUtil.getRedis();
        map.put("attendanceRedis",attendanceRedis);
        return new ModelAndView("teacher/attendanceView",map);
    }


    @GetMapping("/attendanceMap")
    @ResponseBody
    public ModelAndView attendanceMap(String courseId,Map<String,Object> map) {
        List<Attendance> attendanceList = attendanceService.findAllByCourseId(courseId);
        Course course = courseService.findByCourseId(courseId);
        map.put("attendanceList",attendanceList);
        map.put("course",course);
        return new ModelAndView("teacher/attendanceMap",map);
    }

    /**
     * 本地账户密码重置
     * @return
     */
    @RequestMapping("/passwordRest")
    public String passwordRestUI() {
        return "teacher/passwordRest";
    }

    /**
     * 时间转换
     * @param request
     * @param binder
     */
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
