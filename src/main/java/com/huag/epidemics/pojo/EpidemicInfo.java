package com.huag.epidemics.pojo;

import java.util.Date;

public class EpidemicInfo {
    private Integer serialId;
    private Integer provinceId;
    private Short dataYear;
    private Short dataMonth;
    private Short dataDay;
    private Integer affirmed,suspect,isolated,dead,cured;
    private Integer userId;
    private Date inputDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Integer getSerialId() {
        return serialId;
    }

    public void setSerialId(Integer serialId) {
        this.serialId = serialId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Short getDataYear() {
        return dataYear;
    }

    public void setDataYear(Short dataYear) {
        this.dataYear = dataYear;
    }

    public Short getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(Short dataMonth) {
        this.dataMonth = dataMonth;
    }

    public Short getDataDay() {
        return dataDay;
    }

    public void setDataDay(Short dataDay) {
        this.dataDay = dataDay;
    }

    public Integer getAffirmed() {
        return affirmed;
    }

    public void setAffirmed(Integer affirmed) {
        this.affirmed = affirmed;
    }

    public Integer getSuspect() {
        return suspect;
    }

    public void setSuspect(Integer suspect) {
        this.suspect = suspect;
    }

    public Integer getIsolated() {
        return isolated;
    }

    public void setIsolated(Integer isolated) {
        this.isolated = isolated;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    public Integer getCured() {
        return cured;
    }

    public void setCured(Integer cured) {
        this.cured = cured;
    }
}
