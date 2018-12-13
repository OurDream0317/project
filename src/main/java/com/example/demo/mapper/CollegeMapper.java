package com.example.demo.mapper;

import com.example.demo.model.ClassModel;
import com.example.demo.model.College;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CollegeMapper {
    public List<College> seleceAllXY();
    //查询所有专业
    public List<College> seleceAllZY();
    public List<College> seleceAllZY1(@Param("cid") int cid);
    public List<ClassModel> seleceAllClass(@Param("classid") int classid);
}