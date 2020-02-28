package com.huag.epidemics.service.impl;

import com.huag.epidemics.dao.IuserDao;
import com.huag.epidemics.pojo.UserInfo;
import com.huag.epidemics.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
    @Autowired
    IuserDao iuserDao;

    @Override
    public void test() {
        System.out.println("你好呀");
    }

    @Override
    public UserInfo findByAccount(String account) {
        return iuserDao.findByAccount(account);
    }
}
