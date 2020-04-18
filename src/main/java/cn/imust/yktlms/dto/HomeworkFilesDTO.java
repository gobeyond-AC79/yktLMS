package cn.imust.yktlms.dto;

import java.util.Date;

/**
 * @author SERENDIPITY
 */
public class HomeworkFilesDTO {

    private Integer homeworkfilesId;

    /**
     * 作业号
     */
    private String homeworkId;

    /**
     * 学号
     */
    private String studentName;

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

    public HomeworkFilesDTO() {
    }

    public HomeworkFilesDTO(Integer homeworkfilesId, String homeworkId, String studentName, String homeworkFile, Date createTime, Date updateTime) {
        this.homeworkfilesId = homeworkfilesId;
        this.homeworkId = homeworkId;
        this.studentName = studentName;
        this.homeworkFile = homeworkFile;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
