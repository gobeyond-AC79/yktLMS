package cn.imust.yktlms.entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author SERENDIPITY
 */
@Table(name = "homework")
public class Homework implements Serializable {

    private static final long serialVersionUID = 8588870594132670015L;
    /**
     * 作业号
     */
    @Id
    private String homeworkId;

    /**
     * 课程号
     */
    private String courseId;

    /**
     * 作业名称
     */
    private String homeworkName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 截止时间
     */
    private Date stopTime;

    public Homework(String homeworkId, String courseId, String homeworkName, Date createTime, Date stopTime) {
        this.homeworkId = homeworkId;
        this.courseId = courseId;
        this.homeworkName = homeworkName;
        this.createTime = createTime;
        this.stopTime = stopTime;
    }

    public Homework() {
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }
}
