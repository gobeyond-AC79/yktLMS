package cn.imust.yktlms.entity;
import cn.imust.yktlms.annotations.CreateTime;
import cn.imust.yktlms.annotations.UpdateTime;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author SERENDIPITY
 */
@Table(name = "teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1538883497763893726L;
    /**
     * 教工号
     */
    @Id
    private String teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教师性别
     */
    private String teacherSex;

    /**
     * 教师出生日期
     */
    /*@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")*/
    private Date teacherBirthday;

    /**
     * 教师学历
     */
    private String teacherDegree;

    /**
     * 教师级别
     */
    private String teacherTitle;

    /**
     * 教师电话
     */
    private String teacherPhone;

    /**
     * 教师邮箱
     */
    private String teacherEmail;

    /**
     * 状态(0,不可用;1可用)
     */
    private Integer teacherStatus;

    /**
     * 创建时间
     */
    @CreateTime
    private Date createTime;

    /**
     * 修改时间
     */
    @UpdateTime
    private Date updateTime;

    public Teacher(String teacherId, String teacherName, String teacherSex, Date teacherBirthday, String teacherDegree, String teacherTitle, String teacherPhone, String teacherEmail, Integer teacherStatus, Date createTime, Date updateTime) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSex = teacherSex;
        this.teacherBirthday = teacherBirthday;
        this.teacherDegree = teacherDegree;
        this.teacherTitle = teacherTitle;
        this.teacherPhone = teacherPhone;
        this.teacherEmail = teacherEmail;
        this.teacherStatus = teacherStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Teacher() {
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public Date getTeacherBirthday() {
        return teacherBirthday;
    }

    public void setTeacherBirthday(Date teacherBirthday) {
        this.teacherBirthday = teacherBirthday;
    }

    public String getTeacherDegree() {
        return teacherDegree;
    }

    public void setTeacherDegree(String teacherDegree) {
        this.teacherDegree = teacherDegree;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public Integer getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(Integer teacherStatus) {
        this.teacherStatus = teacherStatus;
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
