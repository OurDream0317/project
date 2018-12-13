package com.example.demo.model;

public class Drom {
    private Integer id;

    private String dtype;

    private String dnumber;

    private String dfloor;

    private Integer dnumber1;

    private String dxy;

    private String dzy;

    private String dclass;

    private String dprople;

    private Integer dstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype == null ? null : dtype.trim();
    }

    public String getDnumber() {
        return dnumber;
    }

    public void setDnumber(String dnumber) {
        this.dnumber = dnumber == null ? null : dnumber.trim();
    }

    public String getDfloor() {
        return dfloor;
    }

    public void setDfloor(String dfloor) {
        this.dfloor = dfloor == null ? null : dfloor.trim();
    }

    public Integer getDnumber1() {
        return dnumber1;
    }

    public void setDnumber1(Integer dnumber1) {
        this.dnumber1 = dnumber1;
    }

    public String getDxy() {
        return dxy;
    }

    public void setDxy(String dxy) {
        this.dxy = dxy == null ? null : dxy.trim();
    }

    public String getDzy() {
        return dzy;
    }

    public void setDzy(String dzy) {
        this.dzy = dzy == null ? null : dzy.trim();
    }

    public String getDclass() {
        return dclass;
    }

    public void setDclass(String dclass) {
        this.dclass = dclass == null ? null : dclass.trim();
    }

    public String getDprople() {
        return dprople;
    }

    public void setDprople(String dprople) {
        this.dprople = dprople == null ? null : dprople.trim();
    }

    public Integer getDstatus() {
        return dstatus;
    }

    public void setDstatus(Integer dstatus) {
        this.dstatus = dstatus;
    }
}