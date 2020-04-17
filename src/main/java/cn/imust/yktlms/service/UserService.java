package cn.imust.yktlms.service;


import cn.imust.yktlms.entity.User;

/**
 * @author SERENDIPITY
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 添加用户
     * 每添加一个学生、老师、管理员都要在用户表注册用户
     * @param user
     */
    void addUser(User user);

    /**
     * 用户密码修改
     * @param user
     */
    void updateUser(User user);

    /**
     * 用户删除
     * @param userName
     */
    void removeUser(String userName);

}
