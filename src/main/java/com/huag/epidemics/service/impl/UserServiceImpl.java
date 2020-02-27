package com.huag.epidemics.service.impl;

import com.huag.epidemics.service.IUserService;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
    @Override
    public void test() {
        System.out.println("你好呀");
    }
}
