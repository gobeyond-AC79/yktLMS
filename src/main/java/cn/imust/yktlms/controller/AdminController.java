package cn.imust.yktlms.controller;

import cn.imust.yktlms.dto.CourseDTO;
import cn.imust.yktlms.entity.*;
import cn.imust.yktlms.enums.ResultEnum;
import cn.imust.yktlms.enums.RoleEnum;
import cn.imust.yktlms.exception.YktException;
import cn.imust.yktlms.service.*;
import cn.imust.yktlms.util.IdGenerateUtil;
import cn.imust.yktlms.vo.PagingVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 管理员
 * @author SERENDIPITY
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseSelectionService courseSelectionService;

    @Autowired
    private AttendanceService attendanceService;

    /*-------------------------------------------------课程操作-------------------------------------------------------*/

    /**
     * 课程信息显示
     * @param map
     * @param page
     * @return
     */
    @GetMapping("/showCourse")
    public ModelAndView showCourse(Map<String,Object> map, Integer page) {
        List<Course> courseList  = null;
        List<CourseDTO> coursesList = new ArrayList<>();
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(courseService.getCountCourse());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            courseList = courseService.findByPaging(1);
            for (Course c : courseList) {
                CourseDTO courseDTO = new CourseDTO();
                BeanUtils.copyProperties(c,courseDTO);
                String teacherName = (teacherService.findByTeacherId(c.getTeacherId())).getTeacherName();
                courseDTO.setTeacherName(teacherName);
                coursesList.add(courseDTO);
            }
        }else {
            pagingVO.setToPageNo(page);
            courseList = courseService.findByPaging(page);
            for (Course c : courseList) {
                CourseDTO courseDTO = new CourseDTO();
                BeanUtils.copyProperties(c,courseDTO);
                String teacherName = (teacherService.findByTeacherId(c.getTeacherId())).getTeacherName();
                courseDTO.setTeacherName(teacherName);
                coursesList.add(courseDTO);
            }
        }
        map.put("coursesList",coursesList);
        map.put("pagingVO",pagingVO);
        return new ModelAndView("admin/showCourse",map);
    }

    /**
     * 添加课程
     * @param map
     * @return
     */
    @GetMapping("/addCourse")
    public ModelAndView addCourseUI(Map<String,Object> map) {
        List<Teacher> teacherList = teacherService.findAll();
        map.put("teacherList",teacherList);
        return new ModelAndView("admin/addCourse",map);
    }

    /**
     * 添加课程处理信息
     * @param map
     * @param course
     * @return
     */
    @PostMapping("/addCourse")
    public ModelAndView addCourse(Map<String,Object> map, Course course) {
        if (course.getCourseId() == null) {
            course.setCourseId(IdGenerateUtil.getCourseId());
        }
        Boolean result = courseService.addCourse(course);
        if (!result) {
            map.put("message","课程已存在");
            map.put("url","showCourse");
            return new ModelAndView("common/error",map);
        }
        //重定向
        return new ModelAndView("redirect:/admin/showCourse");
    }

    /**
     * 修改课程信息
     * @param courseId
     * @param map
     * @return
     */
    @GetMapping("/editCourse")
    public ModelAndView editCourseUI(String courseId,Map<String,Object> map) {
        if (courseId == null) {
            //未带回id直接返回课程列表
            return new ModelAndView("redirect:/showCourse");
        }
        Course course = courseService.findByCourseId(courseId);
        if (course == null) {
            //未找到课程抛出异常
            throw new YktException(ResultEnum.NOT_FOUND_COURSE);
        }
        List<Teacher> teacherList = teacherService.findAll();
        map.put("teacherList",teacherList);
        map.put("course",course);
        return new ModelAndView("admin/editCourse",map);
    }

    /**
     * 修改课程信息处理
     * @param course
     * @return
     */
    @PostMapping("/editCourse")
    public String editCourse(Course course) {
        courseService.updateByCourseId(course.getCourseId(),course);
        //重定向
        return "redirect:/admin/showCourse";
    }

    /**
     * 删除课程
     * @param courseId
     * @return
     */
    @GetMapping("/removeCourse")
    public String removeCourse(String courseId) {
        if (courseId == null) {
            return "redirect:/admin/showCourse";
        }
        courseService.removeCourseByCourseId(courseId);
        return "redirect:/admin/showCourse";
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
        if (courseList == null) {
            map.put("message","查找信息有误！");
            map.put("url","showCourse");
            return new ModelAndView("common/error",map);
        }
        map.put("courseList",courseList);
        return new ModelAndView("admin/showCourse",map);
    }

    /*-------------------------------------------------教师操作-------------------------------------------------------*/

    /**
     * 教师列表
     * @param map
     * @param page
     * @return
     */
    @GetMapping("/showTeacher")
    public ModelAndView showTeacher(Map<String,Object> map,Integer page) {
        List<Teacher> teacherList  = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(teacherService.getCountTeacher());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            teacherList = teacherService.findByPaging(1);
        }else {
            pagingVO.setToPageNo(page);
            teacherList = teacherService.findByPaging(page);
        }
        map.put("teacherList",teacherList);
        map.put("pagingVO",pagingVO);
        return new ModelAndView("admin/showTeacher",map);
    }

    @GetMapping("addTeacher")
    public String addTeacherUI(){
        return "admin/addTeacher";
    }

    /**
     * 添加教师
     * @param teacher
     * @param map
     * @return
     */
    @PostMapping("/addTeacher")
    public ModelAndView addTeacher(Teacher teacher,Map<String,Object> map) {
        if (teacher.getTeacherId() == null) {
            teacher.setTeacherId(IdGenerateUtil.getTeacherId());
        }
        Boolean result = teacherService.addTeacher(teacher);
        if (!result) {
            //model.addAttribute("message","已存在");
            //return "error";
            map.put("message","用户已存在！");
            map.put("url","redirect:/showTeacher");
            return new ModelAndView("common/error",map);
        }
        //return "redirect:/admin/showTeacher";
        return new ModelAndView("redirect:/admin/showTeacher");
    }

    /**
     * 修改教师信息页面
     * @param teacherId
     * @param map
     * @return
     */
    @GetMapping("/editTeacher")
    public ModelAndView editTeacherUI(String teacherId,Map<String,Object> map) {
        if (teacherId == null) {
            return new ModelAndView("redirect:/showTeacher");
        }
        Teacher teacher = teacherService.findByTeacherId(teacherId);
        if (teacher == null) {
            throw new YktException(ResultEnum.NOT_FOUND_TEACHER);
        }
        map.put("teacher",teacher);
        return new ModelAndView("admin/editTeacher",map);
    }

    /**
     * 修改教师信息处理
     * @param teacher
     * @return
     */
    @PostMapping("/editTeacher")
    public String editTeacher(Teacher teacher) {
        teacherService.updateByTeacherId(teacher.getTeacherId(),teacher);
        return "redirect:/admin/showTeacher";
    }

    /**
     * 删除教师
     * @param teacherId
     * @return
     */
    @GetMapping("/removeTeacher")
    public ModelAndView removeTeacher(String teacherId,Map<String,Object> map) {
        if (teacherId == null) {
            //没有带id进来的话就返回教师列表页面
            return new ModelAndView("redirect:/admin/showTeacher");
        }
        if((courseService.findByTeacherId(teacherId)) != null) {
            map.put("message","该教师当前正在授课，不可删除");
            map.put("url","showTeacher");
            return new ModelAndView("common/error",map);
        }else {
            teacherService.removeByTeacherId(teacherId);
            return new ModelAndView("redirect:/admin/showTeacher");
        }
    }

    /**
     * 通过姓名搜索教师
     * @param teacherName
     * @param map
     * @return
     */
    @PostMapping("/selectTeacher")
    private ModelAndView selectTeacher(String teacherName,Map<String,Object> map) {
        List<Teacher> teacherList = teacherService.findByTeacherName(teacherName);
        if (teacherList == null) {
            map.put("message","查找信息有误！");
            map.put("url","showTeacher");
            return new ModelAndView("common/error",map);
        }
        map.put("teacherList",teacherList);
        return new ModelAndView("admin/showTeacher",map);
    }

    /*-------------------------------------------------学生操作-------------------------------------------------------*/

    /**
     * 学生列表
     * @param map
     * @param page
     * @return
     * @throws Exception
     */
    @GetMapping("/showStudent")
    public ModelAndView showStudent(Map<String,Object> map, Integer page) {
        List<Student> studentList = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(studentService.getCountStudent());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            studentList = studentService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            studentList = studentService.findByPaging(page);
        }
        map.put("studentList",studentList);
        map.put("pagingVO",pagingVO);
        return new ModelAndView("admin/showStudent",map);
    }

    @GetMapping("addStudent")
    public String addStudentUI() {
        return "admin/addStudent";
    }

    /**
     * 添加学生
     * @param student
     * @param map
     * @return
     */
    @PostMapping("/addStudent")
    public ModelAndView addStudent(Student student,Map<String,Object> map) {
        //先自动生成学号
        if (student.getStudentId() == null) {
            student.setStudentId(IdGenerateUtil.getStudentId());
        }
        Boolean result = studentService.saveStudent(student);
        if (!result) {
            //model.addAttribute("message","添加失败");
            //return "error";
            map.put("message","用户已存在！");
            map.put("url","redirect:/showStudent");
            return new ModelAndView("common/error",map);
        }
        //return "redirect:/admin/showStudent";
        return new ModelAndView("redirect:/admin/showStudent");
    }

    /**
     * 修改学生页面
     * @param studentId
     * @param map
     * @return
     */
    @GetMapping("/editStudent")
    public ModelAndView editStudentUI(String studentId,Map<String,Object> map){
        if (studentId == null) {
            return new ModelAndView("redirect:/showStudent");
        }
        Student student = studentService.findByStudentId(studentId);
        if (student == null) {
            throw new YktException(ResultEnum.NOT_FOUND_STUDENT);
        }
        map.put("student",student);
        return new ModelAndView("admin/editStudent",map);
    }

    /**
     * 修改学生信息处理
     * @param student
     * @return
     */
    @PostMapping("/editStudent")
    public String editStudent(Student student) {
        studentService.updateByStudentId(student.getStudentId(),student);
        return "redirect:/admin/showStudent";
    }

    /**
     * 删除学生信息
     * @param studentId
     * @return
     */
    @GetMapping("/removeStudent")
    public String removeStudent(String studentId) {
        if (studentId == null) {
            return "redirect:/admin/showStudent";
        }
        studentService.deleteByStudentId(studentId);
        return "redirect:/admin/showStudent";
    }

    /**
     * 查找学生
     * @param studentName
     * @param map
     * @return
     */
    @PostMapping("/selectStudent")
    private ModelAndView selectStudent(String studentName,Map<String,Object> map) {
        List<Student> studentList = studentService.findByStudentName(studentName);
        map.put("studentList",studentList);
        if (studentList == null) {
            map.put("message","查找信息有误！");
            map.put("url","showStudent");
            return new ModelAndView("common/error",map);
        }
        return new ModelAndView("admin/showStudent",map);
    }

    /**
     * 查找出学生未选择的课程,并且显示出来
     * @param map
     * @param studentId
     * @return
     */
    @GetMapping("/addCourseToStudent")
    public ModelAndView addCourseToStudentUI(Map<String,Object> map,String studentId) {
        Student student = studentService.findByStudentId(studentId);
        List<String> courseSelected = courseSelectionService.findCourseIdByStudentId(studentId);
        ArrayList<CourseDTO> courseSelectedList = new ArrayList<>();
        ArrayList<CourseDTO> courseList = new ArrayList<>();
        for (String courseId:courseSelected) {
            CourseDTO courseDTO = new CourseDTO();
            Course byCourseId = courseService.findByCourseId(courseId);
            BeanUtils.copyProperties(byCourseId,courseDTO);
            courseDTO.setTeacherName(teacherService.findByTeacherId(byCourseId.getTeacherId()).getTeacherName());
            courseSelectedList.add(courseDTO);
        }
        System.out.println(courseSelected);
        List<Course> courses = courseService.findAll();
        for (String courseId:courseSelected) {
            courses.removeIf(c -> c.getCourseId().equals(courseId));
        }
        for (Course c:courses) {
            CourseDTO courseDTO = new CourseDTO();
            BeanUtils.copyProperties(c,courseDTO);
            courseDTO.setTeacherName(teacherService.findByTeacherId(c.getTeacherId()).getTeacherName());
            courseList.add(courseDTO);
        }
        map.put("courseSelectedList",courseSelectedList);
        map.put("courseList",courseList);
        map.put("student",student);
        return new ModelAndView("admin/addCourseToStudent",map);
    }

    /**
     * 选课
     * @param studentId
     * @param courseId
     * @return
     */
    @PostMapping("/addCourseToStudent")
    public ModelAndView addCourseToStudent(Map<String,Object> map,String studentId,String courseId) {
        courseSelectionService.addCourseToStudent(courseId,studentId);
        Student student = studentService.findByStudentId(studentId);
        Attendance attendance = new Attendance();
        attendance.setCourseId(courseId);
        attendance.setStudentId(studentId);
        attendance.setStudentName(student.getStudentName());
        attendance.setAttendanceNumber(0);
        attendanceService.addAttendance(attendance);
        map.put("studentId",studentId);
        return new ModelAndView("redirect:/admin/addCourseToStudent",map);
    }

    /**
     * 取消选课
     * @param map
     * @param studentId
     * @param courseId
     * @return
     */
    @GetMapping("/removeCourseToStudent")
    public ModelAndView removeCourseToStudent(Map<String,Object> map,String studentId,String courseId) {
        if (studentId == null || courseId == null) {
            return new ModelAndView("redirect:/admin/showCourse");
        }
        courseSelectionService.removeCourseToStudent(studentId,courseId);
        attendanceService.deleteAttendance(studentId,courseId);
        map.put("studentId",studentId);
        return new ModelAndView("redirect:/admin/addCourseToStudent",map);
    }

    /*-------------------------------------------------其它操作-------------------------------------------------------*/

    /**
     * 普通用户账号密码重置
     * @return
     */
    @GetMapping("/userPasswordRest")
    public String userPasswordRestUI() {
        return "admin/userPasswordRest";
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @PostMapping("/userPasswordRest")
    public String userPasswordRest(User user) {
        User users = userService.findByUserName(user.getUserName());
        if (users != null) {
            if (users.getRoleId().equals(RoleEnum.ROLE_ADMIN.getCode())) {
                throw new YktException(ResultEnum.PASSWORD_REST_FAIL);
            }
            user.setSalt(users.getSalt());
            userService.updateUser(user);
        }else{
            throw new YktException(ResultEnum.NOT_FOUND_USER);
        }
        return "admin/userPasswordRest";
    }

    /**
     * 本地账户密码重置
     * @return
     */
    @RequestMapping("/passwordRest")
    public String passwordRestUI() {
        return "admin/passwordRest";
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