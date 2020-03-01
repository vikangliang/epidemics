package com.huag.epidemics.pojo;

import java.util.List;

public class DailyEpidemicInfo {
    private String date;
    private List<EpidemicInfo> array;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<EpidemicInfo> getArray() {
        return array;
    }

    public void setArray(List<EpidemicInfo> array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "DailyEpidemicInfo{" +
                "date='" + date + '\'' +
                ", array=" + array +
                '}';
    }
}
