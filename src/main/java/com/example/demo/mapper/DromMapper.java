package com.example.demo.mapper;

import com.example.demo.model.Drom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DromMapper {
   public List selectAll();
   public void addDrom(Map map);
}