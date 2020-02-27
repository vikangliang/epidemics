package com.huag.epidemics.controller;

import com.huag.epidemics.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @RequestMapping("/login")
    public String login() {
        iUserService.test();
        return "main";
    }
}
