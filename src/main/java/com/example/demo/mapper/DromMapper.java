package com.example.demo.mapper;

import com.example.demo.model.Drom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DromMapper {
   public List selectAll();
   public void addDrom(Map map);
   public List selectDrom(Map map);
   public  Drom selectDromOne(@Param("dtype")String dtype,@Param("dnumber1")String dnumber1);
   Drom selectDromDemo(@Param("id")int id);
   void updatedrom(Map map);
}