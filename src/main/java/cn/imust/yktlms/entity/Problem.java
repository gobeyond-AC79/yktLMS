package cn.imust.yktlms.entity;
import	java.util.Date;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author SERENDIPITY
 */
@Table(name = "problem")
public class Problem {

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
    private Date createTime;

    /**
     * 回答时间
     */
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