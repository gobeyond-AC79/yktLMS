package cn.imust.yktlms.service;

import cn.imust.yktlms.entity.Role;

/**
 * @author SERENDIPITY
 */
public interface RoleService {

    /**
     * 根据id查询角色信息
     * @param roleId
     * @return
     */
    Role findByRoleId(Integer roleId);

}
