package cn.imust.yktlms.service.impl;

import cn.imust.yktlms.entity.Admin;
import cn.imust.yktlms.enums.StatusEnum;
import cn.imust.yktlms.mapper.AdminMapper;
import cn.imust.yktlms.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SERENDIPITY
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void addAdmin(Admin admin) {
        Admin adm = adminMapper.selectByPrimaryKey(admin.getAdminId());
        if (adm == null) {
            adminMapper.insert(admin);
        }
    }

    @Override
    public Boolean removeAdmin(String adminId) {
        Admin admin = adminMapper.selectByPrimaryKey(adminId);
        if (admin.getAdminStatus().equals(StatusEnum.NORMAL_STATUS.getCode())) {
            admin.setAdminStatus(StatusEnum.ERROR_STATUS.getCode());
            adminMapper.updateByPrimaryKeySelective(admin);
            return true;
        }else {
            return false;
        }
    }
}
