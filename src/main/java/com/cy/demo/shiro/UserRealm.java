package com.cy.demo.shiro;

import com.cy.demo.entity.team.UserEo;
import com.cy.demo.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhoudachao on 2018/7/24.
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService iUserService;
    /**
     * 执行授权逻辑
     *
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用
        System.out.println("获取当前用户");
        Subject subject = SecurityUtils.getSubject();
        UserEo tbUser = (UserEo) subject.getPrincipal();
        System.out.println(tbUser.getUserName());

        /*TbUser dbUser = tbUserService.findById(tbUser.getId());*/

        //根据用户id查询相关的权限代码

        /*List<TbPower> powerList = tbUserService.findUserPower(dbUser.getId());*/


        //System.out.println(dbUser.getUsername()+"的权限代码"+);
        //把权限代码然后相应的过滤器中
        /*for(TbPower power : powerList ){
            System.out.println(power.getCode());
            info.addStringPermission(power.getCode());
        }*/
        return info;
    }
    /**
     * 执行认证逻辑
     *
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserEo tbUser = iUserService.queryUserByName(token.getUsername());
        System.out.println(tbUser.getUserName());
        if (tbUser==null){
            //用户名不存在
            return  null;//shiro底层会抛出UnknownAccountException
        }
        //2.判断密码
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(tbUser,tbUser.getPassword(),"");
        //加盐
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(tbUser.getUserName()));
        System.out.println("完成认证");
        return authenticationInfo;

    }


    //踢出前面登录的用户，每次认证前都清除以前的session
    //处理session
      /*  DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
        for(Session session:sessions){
            //清除该用户以前登录时保存的session
            if(token.getUsername().equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) {
                sessionManager.getSessionDAO().delete(session);
            }
        }*/


}
