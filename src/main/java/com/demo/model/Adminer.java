package com.demo.model;

public class Adminer {
    private String name;

    private String pwd;

    private Integer author;

    private String cId;

    public Adminer(String name, String pwd, Integer author, String cId) {
        this.name = name;
        this.pwd = pwd;
        this.author = author;
        this.cId = cId;
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
}