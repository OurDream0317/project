package com.example.demo.mapper;

import com.example.demo.model.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsMapper {
    void addNews(@Param("title") String title,@Param("content") String content,@Param("data") String data,@Param("author") String author);
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
    List<News> selectAll();
}