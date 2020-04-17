package cn.imust.yktlms.dto;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author SERENDIPITY
 */
public class ProblemDTO {

    private Integer problemId;

    /**
     * 课程号
     */
    private String courseId;

    /**
     * 学生姓名
     */
    private String studentName;

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

    public ProblemDTO() {
    }

    public ProblemDTO(Integer problemId, String courseId, String studentName, String problemName, String problemAnswer, Date createTime, Date updateTime) {
        this.problemId = problemId;
        this.courseId = courseId;
        this.studentName = studentName;
        this.problemName = problemName;
        this.problemAnswer = problemAnswer;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
