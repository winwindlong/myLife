package com.dream.myLife.user.sql;

import org.apache.ibatis.annotations.Param;

/**
 * Created by zhang on 2018/2/27.
 */
public class UserSqlProvider {
    public String selectUser(@Param("id") long id) {
        return "select * from u_user where id = " + id;
    }
}
