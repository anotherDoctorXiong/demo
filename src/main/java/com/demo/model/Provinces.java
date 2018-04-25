package com.demo.model;

public class Provinces {
    private Integer id;

    private String provinceid;

    private String province;

    public Provinces(Integer id, String provinceid, String province) {
        this.id = id;
        this.provinceid = provinceid;
        this.province = province;
    }

    public Provinces() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
}