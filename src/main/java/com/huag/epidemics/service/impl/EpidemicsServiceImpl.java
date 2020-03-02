package com.huag.epidemics.service.impl;

import com.huag.epidemics.dao.IepidemicDao;
import com.huag.epidemics.dao.IprovinceDao;
import com.huag.epidemics.pojo.DailyEpidemicInfo;
import com.huag.epidemics.pojo.EpidemicDetailInfo;
import com.huag.epidemics.pojo.EpidemicInfo;
import com.huag.epidemics.pojo.ProvincesInfo;
import com.huag.epidemics.service.IEpidemicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("epidemicsServiceImpl")
public class EpidemicsServiceImpl implements IEpidemicsService {

    @Autowired
    IepidemicDao iepidemicDao;
    @Autowired
    IprovinceDao iprovinceDao;

    @Override
    public List<ProvincesInfo> saveData(DailyEpidemicInfo dailyEpidemicInfo, Integer userId) {
        Date date = new Date();

        String ymd[] = dailyEpidemicInfo.getDate().split("-");
        Short year = Short.parseShort(ymd[0]);
        Short month = Short.parseShort(ymd[1]);
        Short day = Short.parseShort(ymd[2]);
        for (EpidemicInfo epidemicInfo : dailyEpidemicInfo.getArray()) {
            //设置数据录入用户id
            epidemicInfo.setUserId(userId);
            epidemicInfo.setInputDate(date);
            epidemicInfo.setDataYear(year);
            epidemicInfo.setDataMonth(month);
            epidemicInfo.setDataDay(day);
            iepidemicDao.saveInfo(epidemicInfo);
        }

        return iprovinceDao.findNoDataProvinces(year, month, day);
    }

    @Override
    public List<EpidemicDetailInfo> findLastestData() {

        Calendar calendar = new GregorianCalendar();
        short year = (short) calendar.get(Calendar.YEAR);
        short month = (short) (calendar.get(Calendar.MONTH) + 1);
        short day = (short) calendar.get(Calendar.DATE);
        //查询每个省份的累计数量和新增
        Map<String,Short> map=new HashMap<>();
        map.put("year",year);
        map.put("month",month);
        map.put("day",day);
        List<EpidemicDetailInfo> list=this.iepidemicDao.findLastestData(map);
        return list;
    }
}
