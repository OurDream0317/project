package com.example.demo.mapper;

import com.example.demo.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    public List studentLogin(@Param("start") int start,@Param("num") int num);
    public void addStudent(Map map);
    public void delStudent(@Param("id")int id);
    public void delAll(String[] item);
    public List<Student> selectAllStudent();
    public void saveexcel(List list);
    public Student selStudent(Map map);
}