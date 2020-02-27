package com.huag.epidemics.dao;

import com.huag.epidemics.pojo.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IuserDao {
    @Select("select \n" +
            "  `user_id`,\n" +
            "  `account`,\n" +
            "  `password`,\n" +
            "  `user_name`,\n" +
            "  `del_flag` \n" +
            "from\n" +
            "  `epidemic`.`users` \n" +
            "limit 0, 1000 ;")
    public List<UserInfo> getUserInfo();
}
