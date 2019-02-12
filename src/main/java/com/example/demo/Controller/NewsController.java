package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Student;
import com.example.demo.service.NewsService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @RequestMapping("/addNews")
    public String addNews(String title, String content, HttpSession session){
          Student student= (Student) session.getAttribute("student");
          String author=student.getSname();
          newsService.addNews(title,content,author);
        return "redirect:/article-list.html";
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    public String selectAll(){
        List list=newsService.selectAll();
        return JSON.toJSONString(list);
    }
}
