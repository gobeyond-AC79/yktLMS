package cn.imust.yktlms.service;

import cn.imust.yktlms.entity.Admin;

/**
 * @author SERENDIPITY
 */
public interface AdminService {

    /**
     * 添加管理员
     * @param admin
     */
    void addAdmin(Admin admin);

    /**
     * 删除管理员
     * 修改状态
     * @param adminId
     * @return
     */
    Boolean removeAdmin(String adminId);

}
