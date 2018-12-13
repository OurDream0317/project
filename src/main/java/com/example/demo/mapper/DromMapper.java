package com.example.demo.mapper;

import com.example.demo.model.Drom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DromMapper {
   public List selectAll();
}