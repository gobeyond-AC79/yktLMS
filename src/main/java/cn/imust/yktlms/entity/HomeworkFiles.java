package cn.imust.yktlms.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author SERENDIPITY
 */
@Table(name = "homeworkfiles")
public class HomeworkFiles {

    @Id
    private Integer homeworkfilesId;

    /**
     * 作业号
     */
    private String homeworkId;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 提交文件
     */
    private String homeworkFile;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public HomeworkFiles(Integer homeworkfilesId, String homeworkId, String studentId, String homeworkFile, Date createTime, Date updateTime) {
        this.homeworkfilesId = homeworkfilesId;
        this.homeworkId = homeworkId;
        this.studentId = studentId;
        this.homeworkFile = homeworkFile;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public HomeworkFiles() {
    }

    public Integer getHomeworkfilesId() {
        return homeworkfilesId;
    }

    public void setHomeworkfilesId(Integer homeworkfilesId) {
        this.homeworkfilesId = homeworkfilesId;
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getHomeworkFile() {
        return homeworkFile;
    }

    public void setHomeworkFile(String homeworkFile) {
        this.homeworkFile = homeworkFile;
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
