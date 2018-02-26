package com.demo.model;

public class Local {
    private String province;

    private String city;

    private String dist;

    private String cName;

    private String cId;

    private String cLocal;

    public Local(String province, String city, String dist, String cName, String cId, String cLocal) {
        this.province = province;
        this.city = city;
        this.dist = dist;
        this.cName = cName;
        this.cId = cId;
        this.cLocal = cLocal;
    }
    public Local(String cName, String cId) {
        this.cName = cName;
        this.cId = cId;
    }

    public Local() {
        super();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist == null ? null : dist.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcLocal() {
        return cLocal;
    }

    public void setcLocal(String cLocal) {
        this.cLocal = cLocal == null ? null : cLocal.trim();
    }
}