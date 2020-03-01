package com.huag.epidemics.controller;

import com.huag.epidemics.pojo.UserInfo;
import com.huag.epidemics.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @RequestMapping("/login")
    public String login(UserInfo userInfo, Model model, HttpSession session) {
        System.out.println(userInfo.getAccount());
//        iUserService.test();
        UserInfo user = iUserService.findByAccount(userInfo.getAccount());
        if (user == null) {
            //账号不正确
            model.addAttribute("msg", "账号不正确");
            return "login";
        }
        if (user.getPassword().equals(userInfo.getPassword())) {
            //登入成功
            //将用户信息保存到session
            session.setAttribute("loginuser",user);
            return "redirect:/main.jsp";
        }
        //登入失败
        model.addAttribute("msg", "密码不正确");
        return "login";
    }

    @RequestMapping("/logout")
    String logout(HttpSession session){
//        清理session
        session.invalidate();
        return "redirect:/epidemic.jsp";
    }
}
