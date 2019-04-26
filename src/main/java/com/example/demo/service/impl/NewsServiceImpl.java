package com.example.demo.service.impl;

import com.example.demo.mapper.NewsMapper;
import com.example.demo.model.News;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public void addNews(String title, String content,String author) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String data=df.format(new Date());
        int isadmin=1;
        int shstatus=0;
        if("admin".equals(author)){
            isadmin=0;
            shstatus=1;
        }
        newsMapper.addNews(title,content,data,author,isadmin,shstatus);
    }

    @Override
    public List<News> selectAll() {
        return newsMapper.selectAll();
    }

    @Override
    public List<News> selectAll1(String sname) {
        return newsMapper.selectAll1(sname);
    }

    @Override
    public News selectByPk(int id) {
        return newsMapper.selectByPk(id);
    }

    @Override
    public void updateByPk(News news) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String data=df.format(new Date());
        news.setTime(data);
        Map map=new HashMap();
        map.put("news",news);
        newsMapper.updateByPk(map);
    }

    @Override
    public void delOne(int id) {
        newsMapper.delOne(id);
    }

    @Override
    public void sh(int id,int shstatus) {
        newsMapper.sh(id,shstatus);
    }

    @Override
    public void fbNews(int id, int fbstatus) {
           newsMapper.fbNews(id,fbstatus);
    }

    @Override
    public List<News> searchNews(String content) {
        content="%"+content+"%";
        return newsMapper.searchNews(content);
    }

    @Override
    public List<News> searchNews1(String content, String sname) {
        content="%"+content+"%";
        return newsMapper.searchNews1(content,sname);
    }

    @Override
    public List<News> selectNewsByAdmin() {
        return newsMapper.selectNewsByAdmin();
    }

    @Override
    public List<News> selectNewsByStudent() {
        return newsMapper.selectNewsByStudent();
    }

}
