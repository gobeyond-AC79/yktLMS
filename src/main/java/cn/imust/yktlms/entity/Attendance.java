package cn.imust.yktlms.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author SERENDIPITY
 */
@Table(name = "attendance")
public class Attendance {

    @Id
    private Integer attendanceId;
    /**
     * 课程号
     */
    private String courseId;

    /**
     * 签到时间
     */
    private Date createTime;

    /**
     * 学生学号
     */
    private String studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    public Attendance(Integer attendanceId, String courseId, Date createTime, String studentId, String studentName) {
        this.attendanceId = attendanceId;
        this.courseId = courseId;
        this.createTime = createTime;
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Attendance() {
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
