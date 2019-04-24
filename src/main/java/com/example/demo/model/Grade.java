package com.example.demo.model;

public class Grade {
    private Integer id;

    private Integer stuid;

    private Integer claid;

    private Integer proid;

    private Integer colid;

    private String year;

    private String level;

    private String scorename;

    private Double gradenumber;
    private String numberno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getClaid() {
        return claid;
    }

    public void setClaid(Integer claid) {
        this.claid = claid;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getColid() {
        return colid;
    }

    public void setColid(Integer colid) {
        this.colid = colid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getScorename() {
        return scorename;
    }

    public void setScorename(String scorename) {
        this.scorename = scorename;
    }

    public Double getGradenumber() {
        return gradenumber;
    }

    public void setGradenumber(Double gradenumber) {
        this.gradenumber = gradenumber;
    }

    public String getNumberno() {
        return numberno;
    }

    public void setNumberno(String numberno) {
        this.numberno = numberno;
    }
}