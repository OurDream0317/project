package com.example.demo.model;

public class Scores {
    private Integer id;

    private String score;

    private String stype;

    private String surl;

    private String sadress;

    private String steacher;

    private String slevel;

    private String sclass;

    private Integer sstatus;
    private Integer stuid;
    private Integer teacherid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype == null ? null : stype.trim();
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl == null ? null : surl.trim();
    }

    public String getSadress() {
        return sadress;
    }

    public void setSadress(String sadress) {
        this.sadress = sadress == null ? null : sadress.trim();
    }

    public String getSteacher() {
        return steacher;
    }

    public void setSteacher(String steacher) {
        this.steacher = steacher == null ? null : steacher.trim();
    }

    public String getSlevel() {
        return slevel;
    }

    public void setSlevel(String slevel) {
        this.slevel = slevel == null ? null : slevel.trim();
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass == null ? null : sclass.trim();
    }

    public Integer getSstatus() {
        return sstatus;
    }

    public void setSstatus(Integer sstatus) {
        this.sstatus = sstatus;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }
}