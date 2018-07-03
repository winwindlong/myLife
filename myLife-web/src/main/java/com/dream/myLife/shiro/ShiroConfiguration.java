package com.dream.myLife.shiro;//package com.dream.myLife.shiro;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhang on 2018/1/18.
 */
@Configuration
public class ShiroConfiguration {

    /**
     *保证实现了Shiro内部lifecycle函数的bean执行
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "shiroRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public MyLifeShiro shiroRealm() {
        MyLifeShiro realm = new MyLifeShiro();
//        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }

    @Bean(name = "ehCacheManager")
    @DependsOn("lifecycleBeanPostProcessor")
    public EhCacheManager ehCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        return ehCacheManager;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        securityManager.setCacheManager(ehCacheManager());//用户授权/认证信息Cache, 采用EhCache 缓存
        return securityManager;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager  securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
////        Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
////        LogoutFilter logoutFilter = new LogoutFilter();
////        logoutFilter.setRedirectUrl("/login");
////        filters.put("logout", logoutFilter);
////        shiroFilterFactoryBean.setFilters(filters);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
        filterChainDefinitionManager.put("/logout", "logout");
        filterChainDefinitionManager.put("/user/**", "authc,roles[user]");
        filterChainDefinitionManager.put("/shop/**", "authc,roles[shop]");
        filterChainDefinitionManager.put("/admin/**", "authc,roles[admin]");
        filterChainDefinitionManager.put("/login", "anon");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/ajaxLogin", "anon");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/checkLogin.json", "anon");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/loginsuccess.html", "anon");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/error.html", "anon");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/assets/**",  "anon");//静态资源不拦截
        filterChainDefinitionManager.put("/myLifeServlet/**",  "anon");//静态资源不拦截
        filterChainDefinitionManager.put("/pageRedirectServlet/**",  "anon");//静态资源不拦截
        filterChainDefinitionManager.put("/pageHitCounterServlet/**",  "anon");//静态资源不拦截
        filterChainDefinitionManager.put("/testVue",  "anon");//静态资源不拦截

        filterChainDefinitionManager.put("/**",  "authc,roles[user]");//其他资源全部拦截
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
//
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/loginsuccess.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("/error.html");

        return shiroFilterFactoryBean;
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(securityManager);
        return aasa;
    }
}
