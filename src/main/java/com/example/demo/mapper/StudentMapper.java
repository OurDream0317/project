package com.example.demo.mapper;

import com.example.demo.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StudentMapper {
    public List studentLogin(@Param("start") int start,@Param("num") int num);
    public void addStudent(Map map);
    public void delStudent(@Param("id")int id);
    public void delAll(String[] item);
    public List<Student> selectAllStudent();
    Student selectStudentByID(@Param("id") int id);
    public void saveexcel(List list);
    public Student selStudent(Map map);
   Student updateOne(@Param("id")int id);
    void updateStudent(Map map);
    List searchStusent(Map map);
    Student studentMessage(@Param("snumber") String snumber);
    void updatePWD(@Param("pwd") String pwd,@Param("id") int id);
}