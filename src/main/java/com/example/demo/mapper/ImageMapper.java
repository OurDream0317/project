package com.example.demo.mapper;

import com.example.demo.model.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ImageMapper {
    public void addimage(Map map);

    public List selectAll();

    public void updateStatus(@Param("id") int id, @Param("istatus") int istatus);

    public List selectStatus();

    public List selectStatus1(@Param("num") int num);

    void delOne(@Param("id") int id);

    Image selectById(@Param("id") int id);
     void updateOne2(Map map);
     void delAll(String[] item);
     List<Image> selectByBtn(@Param("min") String min,@Param("max") String max,@Param("Myitype") String Myitype);
}