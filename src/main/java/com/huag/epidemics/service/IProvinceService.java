package com.huag.epidemics.service;

import com.huag.epidemics.pojo.ProvincesInfo;

import java.util.List;

public interface IProvinceService {
    List<ProvincesInfo> findNoDataProvinces(String date);
}
