package cn.imust.yktlms.service.impl;

import cn.imust.yktlms.YktlmsApplication;
import cn.imust.yktlms.entity.User;
import cn.imust.yktlms.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUserTest(){
        User user = new User();
        user.setUserName("1667111114");
        user.setRoleId(1);
        userService.addUser(user);
    }

}