package com.demo.model;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Comunity {

    private String province;

    private String city;

    private String dist;
    @Excel(name = "c_id", orderNum = "0")
    private String cId;
    @Excel(name = "c_name", orderNum = "1")
    private String cName;
    @Excel(name = "b_name", orderNum = "2")
    private String bName;
    @Excel(name = "u_name", orderNum = "3")
    private String uName;
    @Excel(name = "h_id", orderNum = "4")
    private Integer hId;
    @Excel(name = "h_name", orderNum = "5")
    private String hName;

    public Comunity(String cId, String cName, String bName, String uName, Integer hId, String hName) {
        this.province=province;
        this.city=city;
        this.dist=dist;
        this.cId = cId;
        this.cName = cName;
        this.bName = bName;
        this.uName = uName;
        this.hId = hId;
        this.hName = hName;
    }
    public  Comunity(String province,String city,String dist,String cId,String cName,String bName){
        this.province=province;
        this.city=city;
        this.dist=dist;
        this.cId=cId;
        this.cName = cName;
        this.bName = bName;
    }
    public  Comunity(String province,String city,String dist,String cId,String cName,String bName,String uName){
        this.province=province;
        this.city=city;
        this.dist=dist;
        this.cId=cId;
        this.cName = cName;
        this.bName = bName;
        this.uName = uName;
    }
    public  Comunity(String province,String city,String dist,String cId,String cName,String bName,String uName,Integer hId,String hName){
        this.province=province;
        this.city=city;
        this.dist=dist;
        this.cId=cId;
        this.cName = cName;
        this.bName = bName;
        this.uName = uName;
        this.hId = hId;
        this.hName = hName;
    }

    public Comunity() {
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

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName == null ? null : hName.trim();
    }
}