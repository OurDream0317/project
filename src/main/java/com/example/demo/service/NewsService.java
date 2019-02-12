package com.example.demo.service;

import com.example.demo.model.News;

import java.util.List;

public interface NewsService {
    void addNews(String title,String content,String author);
    List<News> selectAll();
}
