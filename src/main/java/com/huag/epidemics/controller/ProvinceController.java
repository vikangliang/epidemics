package com.huag.epidemics.controller;

import com.huag.epidemics.pojo.AjaxResponseInfo;
import com.huag.epidemics.pojo.ProvincesInfo;
import com.huag.epidemics.service.IProvinceService;
import com.huag.epidemics.service.impl.ProvinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("provinces")
public class ProvinceController {

    @Autowired
    IProvinceService iProvinceService;

    @GetMapping("/ajax/nodataList")
    @ResponseBody
    public AjaxResponseInfo noDataProvinceList(String date) {
        List<ProvincesInfo> list = null;
        AjaxResponseInfo<List<ProvincesInfo>> responseInfo = new AjaxResponseInfo<>();
        if (!StringUtils.isEmpty(date)) {
            list = this.iProvinceService.findNoDataProvinces(date);
            responseInfo.setData(list);
        } else {
            responseInfo.setCode(-1);
            responseInfo.setMsg("参数不足");
        }
        return responseInfo;
    }


}
