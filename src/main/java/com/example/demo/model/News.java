package com.example.demo.model;

public class News {
    private Integer id;

    private String title;

    private String content;

    private String time;

    private Integer status;

    private String autor;

    private Integer shstatus;

    private Integer fbstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor == null ? null : autor.trim();
    }

    public Integer getShstatus() {
        return shstatus;
    }

    public void setShstatus(Integer shstatus) {
        this.shstatus = shstatus;
    }

    public Integer getFbstatus() {
        return fbstatus;
    }

    public void setFbstatus(Integer fbstatus) {
        this.fbstatus = fbstatus;
    }
}