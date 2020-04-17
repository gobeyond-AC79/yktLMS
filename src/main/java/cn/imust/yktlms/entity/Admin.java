package cn.imust.yktlms.entity;
import	java.util.Date;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author SERENDIPITY
 */
@Table(name = "admin")
public class Admin {

    /**
     * 管理员用户名
     */
    @Id
    private String adminId;

    /**
     * 管理员名称
     */
    private String adminName;

    /**
     * 管理员电话
     */
    private Integer adminPhone;

    /**
     * 状态(0,不可用;1可用)
     */
    private Integer adminStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Admin(String adminId, String adminName, Integer adminPhone, Integer adminStatus, Date createTime, Date updateTime) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPhone = adminPhone;
        this.adminStatus = adminStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Admin() {
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(Integer adminPhone) {
        this.adminPhone = adminPhone;
    }

    public Integer getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Integer adminStatus) {
        this.adminStatus = adminStatus;
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
