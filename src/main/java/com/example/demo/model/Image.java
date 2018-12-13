package com.example.demo.model;

public class Image {
    private Integer id;

    private String ititle;

    private Integer itype;

    private Integer isort;

    private String itime;

    private String iauthor;

    private String idescribe;

    private String iurl;

    private Integer istatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItitle() {
        return ititle;
    }

    public void setItitle(String ititle) {
        this.ititle = ititle == null ? null : ititle.trim();
    }

    public Integer getItype() {
        return itype;
    }

    public void setItype(Integer itype) {
        this.itype = itype;
    }

    public Integer getIsort() {
        return isort;
    }

    public void setIsort(Integer isort) {
        this.isort = isort;
    }

    public String getItime() {
        return itime;
    }

    public void setItime(String itime) {
        this.itime = itime == null ? null : itime.trim();
    }

    public String getIauthor() {
        return iauthor;
    }

    public void setIauthor(String iauthor) {
        this.iauthor = iauthor == null ? null : iauthor.trim();
    }

    public String getIdescribe() {
        return idescribe;
    }

    public void setIdescribe(String idescribe) {
        this.idescribe = idescribe == null ? null : idescribe.trim();
    }

    public String getIurl() {
        return iurl;
    }

    public void setIurl(String iurl) {
        this.iurl = iurl == null ? null : iurl.trim();
    }

    public Integer getIstatus() {
        return istatus;
    }

    public void setIstatus(Integer istatus) {
        this.istatus = istatus;
    }
}