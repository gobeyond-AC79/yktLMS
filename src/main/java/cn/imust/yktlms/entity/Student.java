package cn.imust.yktlms.entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生实体类
 * @author SERENDIPITY
 */
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = -4537704486711185058L;
    /**
     * 学号
     */
    @Id
    private String studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生性别
     */
    private String studentSex;

    /**
     * 学生出生日期
     */
    private Date studentBirthday;

    /**
     * 学生专业
     */
    private String studentSpecialty;

    /**
     * 学生电话
     */
    private String studentPhone;

    /**
     * 学生邮箱
     */
    private String studentEmail;

    /**
     * 状态(0,不可用;1可用)
     */
    private Integer studentStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Student(String studentId, String studentName, String studentSex, Date studentBirthday, String studentSpecialty, String studentPhone, String studentEmail, Integer studentStatus, Date createTime, Date updateTime) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentBirthday = studentBirthday;
        this.studentSpecialty = studentSpecialty;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
        this.studentStatus = studentStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Student() {
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

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getStudentSpecialty() {
        return studentSpecialty;
    }

    public void setStudentSpecialty(String studentSpecialty) {
        this.studentSpecialty = studentSpecialty;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Integer getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Integer studentStatus) {
        this.studentStatus = studentStatus;
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
