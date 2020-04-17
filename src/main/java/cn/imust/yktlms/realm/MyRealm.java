package cn.imust.yktlms.realm;


import cn.imust.yktlms.entity.Role;
import cn.imust.yktlms.entity.User;
import cn.imust.yktlms.service.RoleService;
import cn.imust.yktlms.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * myRealm用户校验
 * @author SERENDIPITY
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = ((User) getAvailablePrincipal(principalCollection)).getUserName();
        Role role = null;
        try {
            User user = userService.findByUserName(username);
            //获取对象角色
            role = roleService.findByRoleId(user.getRoleId());
        }catch (Exception e) {
            e.printStackTrace();
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> set = new HashSet<String> ();
        if (role != null) {
            set.add(role.getRoleName());
            info.setRoles(set);
        }
        return info;
    }

    /**
     * 权限认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        User user = null;
        try{
            user = userService.findByUserName(userName);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            //没有该用户名
            throw new UnknownAccountException();
        }

        //身份验证通过，返回一个身份信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getUserPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return simpleAuthenticationInfo;
    }
}
