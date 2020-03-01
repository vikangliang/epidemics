package com.huag.epidemics.controller;

import com.huag.epidemics.pojo.AjaxResponseInfo;
import com.huag.epidemics.pojo.DailyEpidemicInfo;
import com.huag.epidemics.pojo.ProvincesInfo;
import com.huag.epidemics.pojo.UserInfo;
import com.huag.epidemics.service.IEpidemicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("epidemic")
public class EpidemicsController {
    @Autowired
    IEpidemicsService iEpidemicsService;

    @RequestMapping("/ajax/input")
    @ResponseBody
    public AjaxResponseInfo inputData(@RequestBody DailyEpidemicInfo dailyEpidemicInfo, HttpSession session){
//        System.out.println(dailyEpidemicInfo);
        UserInfo userInfo= (UserInfo) session.getAttribute("loginuser");
        AjaxResponseInfo ajaxResponseInfo=new AjaxResponseInfo();
        if(userInfo==null){
            ajaxResponseInfo.setCode(-2);
            ajaxResponseInfo.setMsg("权限不足");
        }else {
            List<ProvincesInfo> list = this.iEpidemicsService.saveData(dailyEpidemicInfo, userInfo.getUserId());

            ajaxResponseInfo.setData(list);
        }
        return ajaxResponseInfo;
    }
}
