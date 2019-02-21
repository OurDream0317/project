
package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Grade;
import com.example.demo.model.Student;
import com.example.demo.service.GradeService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GradeController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;
    @RequestMapping("/grade/selectAll")
    @ResponseBody
    public String selectAllGrade(String sname,String snumber,String time1,String time2,int xy,int zy,int cla){
        Student student=new Student();
        student.setSname(sname);
        student.setSnumber(snumber);
       Student student1=studentService.selStudent(student);
        Grade grade=new Grade();
        grade.setColid(xy);
        grade.setProid(zy);
        grade.setClaid(cla);
        grade.setStuid(0);
        if(student1!=null){
        grade.setStuid(student1.getId());}
        grade.setYear(time1);
        grade.setLevel(time2);

        List list=gradeService.selectAllGrade(grade);
        return JSON.toJSONString(list);
    }
}

