package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Student student) {
        System.out.println("wangweixiang");
        System.out.println(student.getSname()+""+student.getSpassword());
        if(student.getSname().equals("123") && student.getSpassword().equals("123")){
            /*List list=studentService.studentLogin();
            return JSON.toJSONString(list);*/
            return "index-2";
        }
        else return "login";
    }
    //查询所有的学生
    @RequestMapping("/selAll")
    @ResponseBody
    public String selAll(int start,int num){
        start=(start-1)*num;
        List<Student> list=studentService.studentLogin(start,num);
        return JSON.toJSONString(list);
    }
    @RequestMapping("/addstudent")
    public String addstudent(Student student){
        studentService.addStudent(student);
        return "redirect:/student-list.html";
    }
    @RequestMapping("/delstudent")
    public String delstudent(int id){
        studentService.delStudent(id);
        return "redirect:/student-list.html";
    }
    @RequestMapping("/delAll")
    public String delAll(String ids){
        System.out.println(ids+"====");
        String[] arr=ids.split(",");
        studentService.delAll(arr);
        return "login";
    }
    @RequestMapping("/toLogin")
    public String toLogin(Student student, Model model){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken userToken=new UsernamePasswordToken(student.getSname(),student.getSpassword());
        try{
            subject.login(userToken);
            return "index-2";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            System.out.println("用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            System.out.println("密码错误");
            return "login";
        }
    }

}
