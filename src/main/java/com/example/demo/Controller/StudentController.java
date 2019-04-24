package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Image;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Student student) {
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
    @ResponseBody
    public String delstudent(int id){
        studentService.delStudent(id);
        return JSON.toJSONString("success");
    }
    @RequestMapping("/delAll")
    @ResponseBody
    public String delAll(String[] ids){
        studentService.delAll(ids);
        return JSON.toJSONString("success");
    }
    @RequestMapping("/toLogin")
    public String toLogin(Student student, Model model,HttpSession session){
        Student student1=studentService.selStudent(student);
        if(student1==null){
            model.addAttribute("msg","用户不存在");
            System.out.println("用户不存在");
            return "login";
        }
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken userToken=new UsernamePasswordToken(student1.getSname(),student1.getSpassword());
        try{
            subject.login(userToken);
            Student studentTO=studentService.selStudent(student1);
            if(studentTO.getPersonid()!=student.getPersonid()){
                model.addAttribute("msg","请选择正确的职位");
                System.out.println("请选择正确的职位");
                return "login";
            }
            model.addAttribute("student",studentTO);
            session.setAttribute("student",studentTO);
            if(student.getPersonid()==1){
            return "index-2";}
            else return "index-1";
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
       @RequestMapping("/selectAllStudent")
    @ResponseBody
    public String selectAllStudent(){
        List list=studentMapper.selectAllStudent();
        return JSON.toJSONString(list);
    }
    @RequestMapping("/selectStudentByID")
    @ResponseBody
    public String selectStudentByID(int id){
        Student student=studentMapper.selectStudentByID(id);
        return JSON.toJSONString(student);
    }
    @RequestMapping("/updateOne")
    @ResponseBody
    public String updateOne(int id,HttpSession session){
        session.setAttribute("studentId",id);
        return JSON.toJSONString("success");
    }
    @RequestMapping("/updateOne2")
    @ResponseBody
    public String updateOne2(HttpSession session){
        Student student=studentService.updateOne((Integer) session.getAttribute("studentId"));
        return JSON.toJSONString(student);
    }
    @RequestMapping("/updateStudent")
    public String updateStudent(Student student){
        System.out.println(JSON.toJSONString(student));
        studentService.updateStudent(student);
        return "redirect:/student-list.html";
    }
    @RequestMapping("/searchStusent")
    @ResponseBody
    public String searchStusent(Student student){
        List list=studentService.searchStusent(student);
        return JSON.toJSONString(list);
    }
}
