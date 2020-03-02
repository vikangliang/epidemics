package com.huag.epidemics.pojo;

public class EpidemicDetailInfo extends EpidemicInfo {
    private String provinceName;
    private Integer affirmedTotal,suspectTotal,isolatedTotal,deadTotal,curedTotal;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getAffirmedTotal() {
        return affirmedTotal;
    }

    public void setAffirmedTotal(Integer affirmedTotal) {
        this.affirmedTotal = affirmedTotal;
    }

    public Integer getSuspectTotal() {
        return suspectTotal;
    }

    public void setSuspectTotal(Integer suspectTotal) {
        this.suspectTotal = suspectTotal;
    }

    public Integer getIsolatedTotal() {
        return isolatedTotal;
    }

    public void setIsolatedTotal(Integer isolatedTotal) {
        this.isolatedTotal = isolatedTotal;
    }

    public Integer getDeadTotal() {
        return deadTotal;
    }

    public void setDeadTotal(Integer deadTotal) {
        this.deadTotal = deadTotal;
    }

    public Integer getCuredTotal() {
        return curedTotal;
    }

    public void setCuredTotal(Integer curedTotal) {
        this.curedTotal = curedTotal;
    }
}
