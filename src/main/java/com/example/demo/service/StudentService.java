package com.example.demo.service;

import com.example.demo.model.Student;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

public interface StudentService {
    public List studentLogin(int start,int num);
    public void addStudent(Student student);
    public void delStudent(int id);
    public void delAll(String[] arr);

    public XSSFWorkbook exportExcelInfo(String filename) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException;
    public  void importExcelInfo(InputStream in, MultipartFile file) throws Exception;

    public Student selStudent(String name);
}
