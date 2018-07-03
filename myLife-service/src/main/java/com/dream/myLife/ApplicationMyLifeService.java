package com.dream.myLife;

import com.dream.myLife.cache.service.MemcacheTest;
import com.dream.myLife.test.MapperProxy;
import com.dream.myLife.test.UUser;
import com.dream.myLife.test.UserMapper;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.invoker.Invoker;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhang on 2018/1/13.
 */
@SpringBootApplication
@ImportResource({
        "classpath:/META-INF/spring/appCtx-provider.xml",
        "classpath:/META-INF/cache/spring-memcached.xml"
})
@MapperScan("com.dream.myLife")
public class ApplicationMyLifeService{

    public static void main(String[] args) throws InterruptedException {
        new SpringApplicationBuilder().sources(ApplicationMyLifeService.class).web(false).run(args);
//        MemcacheTest.queryFromCache();
        new CountDownLatch(1).await();

//        SpringApplication.run(ApplicationMyLifeService.class, args);

//        MapperProxy mapperProxy = new MapperProxy();
//        UserMapper uUserMapper = mapperProxy.newInstance(UserMapper.class);
//        UUser uUser = uUserMapper.getUserById(10068L);
//
//        System.out.println("ID:" + uUser.getId());
//        System.out.println("Name:" + uUser.getNickname());
//        System.out.println("Age:" + uUser.getPswd());
//
//        System.out.println(uUserMapper.toString());
//        try {
//            DefaultObjectFactory objectFactory = new DefaultObjectFactory();
//            UUser user = objectFactory.create(UUser.class);
//
//            Reflector reflector = new Reflector(UUser.class);
//
//            Invoker invoker = reflector.getSetInvoker("id");
//            invoker.invoke(user,new Object[]{100L});
//            invoker = reflector.getGetInvoker("id");
//            System.out.print("id=" + invoker.invoke(user,null));
//        }catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}
