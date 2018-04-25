package com.demo.model;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Local {

    @Excel(name = "province", orderNum = "0")
    private String province;
    @Excel(name = "city", orderNum = "1")
    private String city;
    @Excel(name = "dist", orderNum = "2")
    private String dist;
    @Excel(name = "c_name", orderNum = "4")
    private String cName;
    @Excel(name = "c_id", orderNum = "3")
    private String cId;
    @Excel(name = "c_local", orderNum = "5")
    private String cLocal;
    public Local(String cName, String cId){
        this.cName = cName;
        this.cId = cId;
    }

    public Local( String province, String city, String dist, String cName, String cId, String cLocal) {

        this.province = province;
        this.city = city;
        this.dist = dist;
        this.cName = cName;
        this.cId = cId;
        this.cLocal = cLocal;
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