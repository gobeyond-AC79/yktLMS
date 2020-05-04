package cn.imust.yktlms.entity;

import cn.imust.yktlms.annotations.CreateTime;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author SERENDIPITY
 */
@Table(name = "courseselection")
public class CourseSelection implements Serializable {

    private static final long serialVersionUID = 5287048481242055494L;
    @Id
    private Integer selectionId;
    /**
     * 课程号
     */
    private String courseId;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 创建时间
     */
    @CreateTime
    private Date createTime;

    public CourseSelection(Integer selectionId, String courseId, String studentId, Date createTime) {
        this.selectionId = selectionId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.createTime = createTime;
    }

    public CourseSelection() {
    }

    public Integer getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(Integer selectionId) {
        this.selectionId = selectionId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
