package com.dream.myLife.cache.service;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by zhang on 2018/1/17.
 */
@Service
public class MemcacheTest{
    private static MemcachedClient memcachedClient;
    private static ApplicationContext app;
    public static void setMemcachedClient(MemcachedClient memcachedClient) {
        MemcacheTest.memcachedClient = memcachedClient;
    }
    public static Map<String, String> queryFromCache() {
        Map<String, String> users = new HashMap<String, String>();
//        app = new ClassPathXmlApplicationContext("classpath:/META-INF/cache/spring-memcached.xml");
//        memcachedClient = (MemcachedClient) app.getBean("memcachedClient");
            try {
                memcachedClient.set("zlex", 36000, "set/get");
                System.out.println("cache test value is:"+memcachedClient.get("zlex"));;
            } catch (TimeoutException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (MemcachedException e) {
                e.printStackTrace();
            }
        return users;
    }

    public static MemcachedClient getMemcachedClient() {
        return memcachedClient;
    }


}
