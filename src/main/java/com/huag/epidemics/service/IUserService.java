package com.huag.epidemics.service;

import com.huag.epidemics.pojo.UserInfo;

public interface IUserService {
    public void test();

    /**
     * 根据用户账号获取用户信息
     * @return
     */
    UserInfo findByAccount(String account);
}
