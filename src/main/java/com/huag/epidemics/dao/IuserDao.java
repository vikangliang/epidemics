package com.huag.epidemics.dao;

import com.huag.epidemics.pojo.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IuserDao {
    @Select("SELECT \n" +
            "  * \n" +
            "FROM\n" +
            "  `epidemic`.`users` \n" +
            "WHERE `account`=#{account}" +
            "AND `del_flag` IS NULL OR `del_flag`=0\n" +
            "LIMIT 0, 1000 ;")
    public UserInfo findByAccount(String account);
}
