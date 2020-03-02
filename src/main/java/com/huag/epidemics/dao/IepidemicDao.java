package com.huag.epidemics.dao;

import com.huag.epidemics.pojo.EpidemicDetailInfo;
import com.huag.epidemics.pojo.EpidemicInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IepidemicDao {
    /**
     * 保存疫情信息
     * @param epidemicInfo
     * @return
     */
    @Insert("INSERT INTO `epidemic`.`epidemics` (\n" +
            "  `province_id`,\n" +
            "  `data_year`,\n" +
            "  `data_month`,\n" +
            "  `data_day`,\n" +
            "  `affirmed`,\n" +
            "  `suspect`,\n" +
            "  `isolated`,\n" +
            "  `dead`,\n" +
            "  `cured`,\n" +
            "  `user_id`,\n" +
            "  `input_date`\n" +
            ") \n" +
            "VALUES\n" +
            "  (\n" +
            "    #{provinceId},\n" +
            "    #{dataYear},\n" +
            "    #{dataMonth},\n" +
            "    #{dataDay},\n" +
            "    #{affirmed},\n" +
            "    #{suspect},\n" +
            "    #{isolated},\n" +
            "    #{dead},\n" +
            "    #{cured},\n" +
            "    #{userId},\n" +
            "    #{inputDate}\n" +
            "  ) ;")
    int saveInfo(EpidemicInfo epidemicInfo);

    @Select("SELECT epidemics.`province_id`,temp.province_name,epidemics.`affirmed`,epidemics.`suspect`,epidemics.`isolated`,\n" +
            "epidemics.`cured`,epidemics.`dead`,\n" +
            "temp.province_id,\n" +
            "affirmed_total,\n" +
            "suspect_total,\n" +
            "isolated_total,\n" +
            "dead_total,\n" +
            "cured_total\n" +
            "FROM epidemics RIGHT OUTER JOIN (SELECT epidemics.`province_id`,provinces.`province_name`,\n" +
            "SUM(epidemics.`affirmed`) affirmed_total,SUM(epidemics.`suspect`) suspect_total,\n" +
            "SUM(epidemics.`isolated`) isolated_total,SUM(epidemics.`dead`) dead_total,SUM(epidemics.`cured`) cured_total\n" +
            "FROM epidemics RIGHT OUTER JOIN provinces ON epidemics.`province_id`=provinces.`province_id`\n" +
            "GROUP BY epidemics.`province_id`) temp ON epidemics.`province_id`=temp.province_id\n" +
            "WHERE epidemics.`data_year`=#{year}\n" +
            "AND epidemics.`data_month`=#{month}\n" +
            "AND epidemics.`data_day`=#{day}\n")
    List<EpidemicDetailInfo> findLastestData(Map<String, Short> map);
}
