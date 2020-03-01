package com.huag.epidemics.dao;

import com.huag.epidemics.pojo.EpidemicInfo;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

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
            "    #{serialId},\n" +
            "    #{dataYear},\n" +
            "    #{dataMonth},\n" +
            "    #{dataDay},\n" +
            "    #{affirmed},\n" +
            "    #{suspect),\n" +
            "    #{isolated},\n" +
            "    #{dead},\n" +
            "    #{cured},\n" +
            "    #{user_id},\n" +
            "    #{input_date}\n" +
            "  ) ;")
    int saveInfo(EpidemicInfo epidemicInfo);
}
