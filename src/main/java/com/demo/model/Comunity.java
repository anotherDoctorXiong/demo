package com.demo.model;

public class Comunity {
    private String cId;

    private String cName;

    private String bName;

    private String uName;

    private Integer hId;

    private String hName;

    public Comunity(String cId, String cName, String bName, String uName, Integer hId, String hName) {
        this.cId = cId;
        this.cName = cName;
        this.bName = bName;
        this.uName = uName;
        this.hId = hId;
        this.hName = hName;
    }

    public Comunity() {
        super();
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