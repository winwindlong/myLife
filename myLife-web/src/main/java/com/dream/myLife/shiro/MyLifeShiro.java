package com.dream.myLife.shiro;//package com.dream.myLife.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by zhang on 2018/1/18.
 */
public class MyLifeShiro extends AuthorizingRealm  {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";

    private Logger logger= LoggerFactory.getLogger(MyLifeShiro.class);

    /**
     *
     *权限认证
     * @return
     * @throws AuthenticationException
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo");
        Set<String> roleNames = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        roleNames.add("admin");//添加角色
        permissions.add("newPage.html");  //添加权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     *
     * 登录认证
     * @return
     */
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException  {
//        logger.info("doGetAuthorizationInfo");
//            UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//            if(token.getUsername().equals(USER_NAME)){
//                return new SimpleAuthenticationInfo(USER_NAME, PASSWORD, getName());
//            }else{
//                throw new AuthenticationException();
//            }
//    }

    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        if(token.getUsername().equals(USER_NAME)){
            return new SimpleAuthenticationInfo(USER_NAME, PASSWORD, getName());
        }else{
            throw new AuthenticationException();
        }
    }
}
