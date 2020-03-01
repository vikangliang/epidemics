package com.huag.epidemics.service.impl;

import com.huag.epidemics.dao.IepidemicDao;
import com.huag.epidemics.dao.IprovinceDao;
import com.huag.epidemics.pojo.DailyEpidemicInfo;
import com.huag.epidemics.pojo.EpidemicInfo;
import com.huag.epidemics.pojo.ProvincesInfo;
import com.huag.epidemics.service.IEpidemicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("epidemicsServiceImpl")
public class EpidemicsServiceImpl implements IEpidemicsService {

    @Autowired
    IepidemicDao iepidemicDao;
    @Autowired
    IprovinceDao iprovinceDao;

    @Override
    public List<ProvincesInfo> saveData(DailyEpidemicInfo dailyEpidemicInfo,Integer userId) {
        Date date=new Date();

        String ymd[]=dailyEpidemicInfo.getDate().split("-");
        Short year=Short.parseShort(ymd[0]);
        Short month=Short.parseShort(ymd[1]);
        Short day=Short.parseShort(ymd[2]);
        for (EpidemicInfo epidemicInfo:dailyEpidemicInfo.getArray()){
            //设置数据录入用户id
epidemicInfo.setUserId(userId);
epidemicInfo.setInputDate(date);
epidemicInfo.setDataYear(year);
epidemicInfo.setDataMonth(month);
epidemicInfo.setDataDay(day);
//iepidemicDao.saveInfo(epidemicInfo);
        }

        return iprovinceDao.findNoDataProvinces(year,month,day);
    }
}
