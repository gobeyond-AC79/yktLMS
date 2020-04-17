package cn.imust.yktlms.controller;

import cn.imust.yktlms.entity.User;
import cn.imust.yktlms.enums.ResultEnum;
import cn.imust.yktlms.exception.YktException;
import cn.imust.yktlms.service.UserService;
import cn.imust.yktlms.util.PasswordGenerateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SERENDIPITY
 */
@Controller
public class PasswordRestController {

    @Autowired
    private UserService userService;

    /**
     * 修改密码并且退出登录
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @PostMapping("/passwordRest")
    public String passwordRest(String oldPassword,String newPassword) {
        Subject subject = SecurityUtils.getSubject();
        /*String userName = ((User) subject.getPrincipal()).getUserName();
        User user = userService.findByUserName(userName);*/
        User user = (User) subject.getPrincipal();
        if (!(PasswordGenerateUtil.passwordEncryption(oldPassword,user.getSalt(),2)).equals(user.getUserPassword())) {
            throw new YktException(ResultEnum.NOT_SAME_PASSWORD);
        }else {
            user.setUserPassword(newPassword);
            userService.updateUser(user);
        }
        return "redirect:/logout";
    }
}
