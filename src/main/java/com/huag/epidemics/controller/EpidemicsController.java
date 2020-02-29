package com.huag.epidemics.controller;

import com.huag.epidemics.pojo.AjaxResponseInfo;
import com.huag.epidemics.service.IEpidemicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("epidemic")
public class EpidemicsController {
    @Autowired
    IEpidemicsService iEpidemicsService;

    @RequestMapping("/ajax/input")
    @ResponseBody
    public AjaxResponseInfo inputData(Model model){
        AjaxResponseInfo ajaxResponseInfo=new AjaxResponseInfo();
        return ajaxResponseInfo;
    }
}
