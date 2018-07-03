package com.dream.myLife.user.mapper;

import com.dream.myLife.user.entity.UUser;
import com.dream.myLife.user.sql.UserSqlProvider;
import org.apache.ibatis.annotations.*;

/**
 * Created by zhang on 2018/2/27.
 */
public interface NewUserMapper {
    @SelectProvider(type = UserSqlProvider.class, method = "selectUser")
//    @Results({
//            @Result(property = "nickname",  column = "nickname"),
//            @Result(property = "email", column = "email")
//    })
    public UUser getUser(@Param("id")long id);

    @Select("SELECT * FROM u_user WHERE id = #{id}")
    @Results({
            @Result(property = "nickname",  column = "nickname"),
            @Result(property = "email", column = "email")
    })
    UUser getOne(long id);
}
