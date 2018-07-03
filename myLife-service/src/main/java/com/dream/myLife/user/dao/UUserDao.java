package com.dream.myLife.user.dao;

import com.dream.myLife.UUserMapper;
import com.dream.myLife.user.entity.UUser;
import com.dream.myLife.user.entity.UUserCondition;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhang on 2018/2/11.
 */
@Repository
public class UUserDao{
    private static final String MAPPER_NAMESPACE = "com.dream.myLife.user.entity.UserMapper";
    @Resource
    private UUserMapper userMapper;

    public List<UUser> getUserByName(String userName) {
        UUserCondition condition = new UUserCondition();
        condition.createCriteria().andNicknameLike(userName);
        return userMapper.selectByExample(condition);
    }

    public List<UUser> getUserByEmail(String email) {
        UUserCondition condition = new UUserCondition();
        condition.createCriteria().andEmailLike("%" + email + "%");
        return userMapper.selectByExample(condition);
    }
}
