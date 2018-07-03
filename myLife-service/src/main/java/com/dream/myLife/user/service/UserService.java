package com.dream.myLife.user.service;

import com.dream.myLife.UUserMapper;
import com.dream.myLife.cache.service.MemcacheTest;
import com.dream.myLife.cache.util.MemcachedUtil;
import com.dream.myLife.user.dao.UUserDao;
import com.dream.myLife.user.entity.UUser;
import com.dream.myLife.user.mapper.NewUserMapper;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by zhang on 2018/1/15.
 */
@Service
public class UserService implements IUserService{
    private static Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UUserDao userDao;
    @Autowired
    private UUserMapper userMapper;
    @Autowired
    private NewUserMapper newUserMapper;

    public void test() {
        List<UUser> uUsers =  userDao.getUserByName("admin");
        UUser uUser = uUsers.get(0);
        System.out.println("test-------------user0"+uUser.getNickname());
        UUser uUser1 = userMapper.selectByPrimaryKey(uUser.getId());
        System.out.println("test-------------user1"+uUser1.getNickname());

        UUser uUser2 = newUserMapper.getOne(2);
        System.out.println("test-------------user2"+uUser2.getNickname());

        UUser uUser3 = newUserMapper.getUser(3);
        System.out.println("test-------------user3"+uUser3.getNickname());

        List<UUser> uUserList = userDao.getUserByEmail("22");
        try {
            MemcachedUtil.getMemcachedClient().set("zlex", 36000, "set/get init");
            System.out.println("cache test value is:"+MemcachedUtil.getMemcachedClient().get("zlex"));

            MemcachedUtil.getMemcachedClient().set("userEmail", 36000, uUserList.get(0).getNickname());
            System.out.println("cache test value is:"+MemcachedUtil.getMemcachedClient().get("userEmail"));;
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }
}
