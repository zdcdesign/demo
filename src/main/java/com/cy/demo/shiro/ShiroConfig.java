package com.cy.demo.shiro;

/**
 * Created by zhoudachao on 2018/7/24.
 */

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置类
 * @author  dachao
 */
@Configuration
public class ShiroConfig {

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultSecurityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *    anon:无需认证（登录）可以访问
         *    authc:必须认证才可以访问
         *    user:如果使用rememberMe的功能可以直接访问
         *    perms:该资源必须得到资源权限才可以访问
         *    role：该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<String,String>();

       /* filterMap.put("/add","authc");
        filterMap.put("/update","authc");*/
        /*filterMap.put("/topic/findTopicPage","authc");
        filterMap.put("/topic/queryAllTopic","authc");
        filterMap.put("/topic/add","authc");
        filterMap.put("/topic/update","authc");
        filterMap.put("/topic/findTopicById","authc");
        filterMap.put("/topic/delete","authc");*/
     //   filterMap.put("/topic*//**","perms[admin:topic]");
      //  filterMap.put("/user*//**","perms[admin:user]");


        filterMap.put("/userLogin/login","anon");
        filterMap.put("/register","anon");
        filterMap.put("/testThymeleaf","anon");
        filterMap.put("/login","anon");
        filterMap.put("/noAuth","anon");
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
       // filterMap.put("/add","perms[user:add]");

        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
      /* filterMap.put("/add","authc,perms[user:add]");
       filterMap.put("/update","perms[user:update]");
        filterMap.put("/query","perms[user:query]");*/

        //放行login.html
      //  filterMap.put("/login","anon");
        //拦截所有的资源
       // filterMap.put("/*","authc");

        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        //修改调整的登录页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        System.out.println("添加权限路径");
        return shiroFilterFactoryBean;
    }

    /**
     *创建一个默认的安全管理器 DefaultWebSecurityManager
     */
    /*@Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
           DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
           securityManager.setRealm(userRealm);
           return securityManager;
    }
*/
    /**
     * hyn的类
     * @return
     */
    @Bean(name = "defaultSecurityManager")
    public DefaultWebSecurityManager defaultSecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(getRealm());
        return defaultWebSecurityManager;
    }
    /*
       创建Realm
     */
    @Bean(name="userRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public UserRealm getRealm(){
        UserRealm userRealm = new UserRealm();

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);

        userRealm.setCredentialsMatcher(matcher);
        return  userRealm;
    }

    /**
     * 配置ShiroDialect,用于thymeleaf和shiro标签配合使用
     * @return
     */
    /*@Bean
    public ShiroDialect getShiroDialect(){
        return  new ShiroDialect();
    }*/

    /*@Bean
    public SessionManager getSessionManager(){
        return  new SessionManager();
    }*/

    /**
     * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    /**
     * AuthorizationAttributeSourceAdvisor，shiro里实现的Advisor类，
     * 内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法。
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor aASA = new AuthorizationAttributeSourceAdvisor();
        aASA.setSecurityManager(defaultSecurityManager());
        return aASA;
    }


}
