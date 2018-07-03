package com.dream.myLife;

import com.dream.myLife.user.entity.TUser;
import com.dream.myLife.user.entity.TUserCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserMapper {
    long countByExample(TUserCondition example);

    int deleteByExample(TUserCondition example);

    int deleteByPrimaryKey(String userid);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserCondition example);

    TUser selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserCondition example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserCondition example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}