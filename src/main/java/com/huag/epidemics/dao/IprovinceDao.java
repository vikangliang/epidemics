package com.huag.epidemics.dao;

import com.huag.epidemics.pojo.ProvincesInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IprovinceDao {

    @Select("select province_id,province_name,province_py\n" +
            "from provinces\n" +
            "where (provinces.`del_flag` is null or provinces.`del_flag`=0)\n" +
            "and provinces.`province_id` not in (\n" +
            "\tselect epidemics.`province_id`\n" +
            "\tfrom epidemics\n" +
            "\twhere epidemics.`data_year`=#{year} and epidemics.`data_month`=#{month} and epidemics.`data_day`=#{day}\n" +
            ")")
    public List<ProvincesInfo> findNoDataProvinces(short year,short month,short day);
}
