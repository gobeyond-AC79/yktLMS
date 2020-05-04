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
@Table(name = "problem")
public class Problem implements Serializable {

    private static final long serialVersionUID = -7491594244992801072L;
    @Id
    private Integer problemId;

    /**
     * 课程号
     */
    private String courseId;

    /**
     * 学生学号
     */
    private String studentId;

    /**
     * 问题名称
     */
    private String problemName;

    /**
     * 问题回答
     */
    private String problemAnswer;

    /**
     * 创建时间
     */
    @CreateTime
    private Date createTime;

    /**
     * 回答时间
     */
    @UpdateTime
    private Date updateTime;

    public Problem(Integer problemId, String courseId, String studentId, String problemName, String problemAnswer, Date createTime, Date updateTime) {
        this.problemId = problemId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.problemName = problemName;
        this.problemAnswer = problemAnswer;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Problem() {
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
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

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public String getProblemAnswer() {
        return problemAnswer;
    }

    public void setProblemAnswer(String problemAnswer) {
        this.problemAnswer = problemAnswer;
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
