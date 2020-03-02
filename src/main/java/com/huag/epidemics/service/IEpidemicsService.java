package com.huag.epidemics.service;

import com.huag.epidemics.pojo.*;

import java.util.List;

public interface IEpidemicsService {
    /**
     * 保存当日疫情，返回未录入列表
     * @param dailyEpidemicInfo
     * @return
     */
    List<ProvincesInfo> saveData(DailyEpidemicInfo dailyEpidemicInfo, Integer userId);

    /**
     * 获取最新疫情数据
     * @return
     */
    List<EpidemicDetailInfo> findLastestData();
}
