package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.List;


public interface StudentService {
    public List studentLogin(int start,int num);
    public void addStudent(Student student);
    public void delStudent(int id);
    public void delAll(String[] arr);
    public  void importExcelInfo(InputStream in, MultipartFile file) throws Exception;

    public Student selStudent(Student student);
    Student updateOne(int id);
    void updateStudent(Student student);
    List searchStusent(Student student);
    Student studentMessage(String snumber);
    void updatePWD( String pwd,int id);
}
