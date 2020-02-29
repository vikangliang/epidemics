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
            "\twhere epidemics.`data_year`=#{arg0} and epidemics.`data_month`=#{arg1} and epidemics.`data_day`=#{arg2}\n" +
            ")order by provinces.`province_py`\n" +
            "            limit 0,6")
    public List<ProvincesInfo> findNoDataProvinces(short year,short month,short day);
}
