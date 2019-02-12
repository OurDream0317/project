package com.example.demo.service.impl;

import com.example.demo.mapper.NewsMapper;
import com.example.demo.model.News;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public void addNews(String title, String content,String author) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String data=df.format(new Date());
        newsMapper.addNews(title,content,data,author);
    }

    @Override
    public List<News> selectAll() {
        return newsMapper.selectAll();
    }

}
