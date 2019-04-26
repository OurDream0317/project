package com.example.demo.service;

import com.example.demo.model.News;

import java.util.List;

public interface NewsService {
    void addNews(String title,String content,String author);
    List<News> selectAll();
    List<News> selectAll1(String sname);
    News selectByPk(int id);
    void updateByPk(News news);
    void delOne(int id);
    void sh(int id,int shstaatus);
    void fbNews(int id,int fbstatus);
    List<News> searchNews(String content);
    List<News> searchNews1(String content,String sname);
    List<News> selectNewsByAdmin();
    List<News> selectNewsByStudent();
}
