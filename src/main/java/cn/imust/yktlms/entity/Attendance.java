package cn.imust.yktlms.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author SERENDIPITY
 */
@Table(name = "attendance")
public class Attendance implements Serializable {

    private static final long serialVersionUID = 7186595839760514803L;
    @Id
    private Integer attendanceId;
    /**
     * 课程号
     */
    private String courseId;

    /**
     * 学生学号
     */
    private String studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 签到次数
     */
    private Integer attendanceNumber;

    /**
     * 签到时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Attendance() {
    }

    public Attendance(Integer attendanceId, String courseId, String studentId, String studentName, Integer attendanceNumber, Date createTime, Date updateTime) {
        this.attendanceId = attendanceId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.attendanceNumber = attendanceNumber;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public Integer getAttendanceNumber() {
        return attendanceNumber;
    }

    public void setAttendanceNumber(Integer attendanceNumber) {
        this.attendanceNumber = attendanceNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
