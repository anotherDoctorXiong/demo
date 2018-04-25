package com.demo.model;

import java.io.Serializable;

public class Adminer implements Serializable {
    private String name;

    private String pwd;

    private Integer author;

    private String cId;

    private String cName;

    private String bName;

    private String uName;

    private Boolean authAdd;

    private Boolean authEdit;

    private Boolean authDelete;

    public Adminer(String name, String pwd, Integer author, String cId, String cName, String bName, String uName, Boolean authAdd, Boolean authEdit
    ,Boolean authDelete) {
        this.name = name;
        this.pwd = pwd;
        this.author = author;
        this.cId = cId;
        this.cName = cName;
        this.bName = bName;
        this.uName = uName;
        this.authAdd = authAdd;
        this.authEdit = authEdit;
        this.authDelete = authDelete;
    }

    public Adminer() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
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

    public Boolean getAuthAdd() {
        return authAdd;
    }

    public void setAuthAdd(Boolean authAdd) {
        this.authAdd = authAdd;
    }

    public Boolean getAuthEdit() {
        return authEdit;
    }

    public void setAuthEdit(Boolean authEdit) {
        this.authEdit = authEdit;
    }

    public Boolean getAuthDelete() {
        return authDelete;
    }

    public void setAuthDelete(Boolean authDelete) {
        this.authDelete = authDelete;
    }
}