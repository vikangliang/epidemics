package com.huag.epidemics.service.impl;

import com.huag.epidemics.pojo.UserInfo;
import com.huag.epidemics.service.IUserService;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
    @Override
    public void test() {
        System.out.println("你好呀");
    }

    @Override
    public UserInfo findByAccount(String account) {
        return null;
    }
}
