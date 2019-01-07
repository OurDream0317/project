package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface ImageMapper {
  public void addimage(Map map);
  public List selectAll();
  public void updateStatus(@Param("id") int id,@Param("istatus") int istatus);
  public List selectStatus();
  public List selectStatus1(@Param("num") int num);
}