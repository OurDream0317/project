package com.example.demo.mapper;

import com.example.demo.model.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface NewsMapper {
    void addNews(@Param("title") String title,@Param("content") String content,@Param("data") String data,@Param("author") String author);
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPk(@Param("id") int id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
    List<News> selectAll();
    List<News> searchNews(@Param("content") String content);
    void updateByPk(Map map);
    void delOne(@Param("id") int id);
    void sh(@Param("id") int id,@Param("shstatus") int shstatus);
    void fbNews(@Param("id") int id,@Param("fbstatus") int fbstatus);
}