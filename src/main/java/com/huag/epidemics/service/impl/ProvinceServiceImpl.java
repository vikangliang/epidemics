package com.huag.epidemics.service.impl;

import com.huag.epidemics.dao.IprovinceDao;
import com.huag.epidemics.pojo.ProvincesInfo;
import com.huag.epidemics.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("provinceServiceImpl")
public class ProvinceServiceImpl implements IProvinceService {

    @Autowired
    IprovinceDao iprovinceDao;

    @Override
    public List<ProvincesInfo> findNoDataProvinces(String date) {
        short year=0,month=0,day=0;
        String arr[]=date.split("-");
        if(arr.length>=3){
            year=Short.parseShort(arr[0]);
            month=Short.parseShort(arr[1]);
            day=Short.parseShort(arr[2]);
        }
        List<ProvincesInfo> list=this.iprovinceDao.findNoDataProvinces(year,month,day);
        return list;
    }
}
