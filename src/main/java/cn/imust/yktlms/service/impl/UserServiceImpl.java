package cn.imust.yktlms.service.impl;


import cn.imust.yktlms.entity.User;
import cn.imust.yktlms.mapper.UserMapper;
import cn.imust.yktlms.service.UserService;
import cn.imust.yktlms.util.PasswordGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SERENDIPITY
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 散列次数
     */
    private static final Integer HASH_TIME = 2;

    @Autowired
    private UserMapper userMapper;

    /**
     * 根绝用户名查询用户
     * @param userName
     * @return
     */
    @Override
    public User findByUserName(String userName) {
        return userMapper.selectByPrimaryKey(userName);
    }

    @Override
    public void addUser(User user) {
        if (user.getUserPassword() == null) {
            user.setUserPassword(PasswordGenerateUtil.passwordGenerate(user.getUserName()));
        }
        if (user.getSalt() == null) {
            user.setSalt(PasswordGenerateUtil.saltGenerate(user.getUserName()));
        }
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        user.setUserPassword(PasswordGenerateUtil.passwordEncryption(user.getUserPassword(),user.getSalt(),HASH_TIME));
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void removeUser(String userName) {
        userMapper.deleteByPrimaryKey(userName);
    }
}
