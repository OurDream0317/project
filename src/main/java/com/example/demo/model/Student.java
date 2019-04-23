package com.example.demo.model;

public class Student {
    private Integer id;

    private String sname;

    private String spassword;

    private String sphone;
    private String snumber;
    private int sage;
    private String sbrithday;
    private int classid;
    private int colid;
    private int proid;
    private int delstatus;
    private int personid;
    private String stime;
 private String xyName;
    private String zyName;
    private String cname;
    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getDelstatus() {
        return delstatus;
    }

    public void setDelstatus(int delstatus) {
        this.delstatus = delstatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword == null ? null : spassword.trim();
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone == null ? null : sphone.trim();
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSbrithday() {
        return sbrithday;
    }

    public void setSbrithday(String sbrithday) {
        this.sbrithday = sbrithday;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public int getColid() {
        return colid;
    }

    public void setColid(int colid) {
        this.colid = colid;
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getXyName() {
        return xyName;
    }

    public void setXyName(String xyName) {
        this.xyName = xyName;
    }

    public String getZyName() {
        return zyName;
    }

    public void setZyName(String zyName) {
        this.zyName = zyName;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}