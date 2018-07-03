package com.dream.myLife;


import com.dream.myLife.filter.LogFilter;
import com.dream.myLife.servlet.PageHitCounterServlet;
import com.dream.myLife.servlet.myLifeServlet;
import com.dream.myLife.servlet.pageRedirectServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ImportResource({
        "classpath:/META-INF/spring/appCtx-consumer.xml"
})
@ServletComponentScan
public class ApplicationMyLifeWeb {



    public static void main(String[] args) {
//        String a="loveanextacsdnaajavaeye";
//        List<String> digitList = new ArrayList<String>();
//        Pattern p = Pattern.compile("[^0-9]");
//        Matcher m = p.matcher(a);
//        String result = m.replaceAll("");
//        if (result.length()>0){
//            System.out.println("true");
//        }
//        System.out.println(result);
        SpringApplication.run(ApplicationMyLifeWeb.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new myLifeServlet(), "/myLifeServlet/*");
        servletRegistrationBean.setLoadOnStartup(2);
        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean pageRedirectServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new pageRedirectServlet(), "/pageRedirectServlet/*");
        servletRegistrationBean.setLoadOnStartup(3);
        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean pageHitCounterServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new PageHitCounterServlet(), "/pageHitCounterServlet/*");
        servletRegistrationBean.setLoadOnStartup(2);
        return servletRegistrationBean;
    }

    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean logFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LogFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("Site", "菜鸟教程");
        registration.setName("logFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }
}

