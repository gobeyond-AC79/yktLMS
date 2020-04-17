package cn.imust.yktlms.service.impl;

import cn.imust.yktlms.entity.Role;
import cn.imust.yktlms.mapper.RoleMapper;
import cn.imust.yktlms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SERENDIPITY
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findByRoleId(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
}
