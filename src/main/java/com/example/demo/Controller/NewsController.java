package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.News;
import com.example.demo.model.Student;
import com.example.demo.service.NewsService;
import org.apache.tomcat.util.buf.Utf8Encoder;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @RequestMapping(value = "/selectAll")
    @ResponseBody
    public String selectAll(String content, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if (student.getSname().equals("admin")) {
            List list = null;
            if (content.length() <= 0 || content == null) {
                list = newsService.selectAll();
            } else {
                list = newsService.searchNews(content);
            }
            return JSON.toJSONString(list);
        }else{
            List list = null;
            if (content.length() <= 0 || content == null) {
                list = newsService.selectAll1(student.getSname());
            } else {
                list = newsService.searchNews1(content,student.getSname());
            }
            return JSON.toJSONString(list);
        }
    }
    @RequestMapping("/selectByPk")
    public String selectByPk(int tmp,HttpSession session){
        session.setAttribute("articleId",tmp);
        return "redirect:/edit-article.html";
    }
    @RequestMapping("/selectByPk1")
    @ResponseBody
    public String selectByPk1(HttpSession session){
        int id= (int) session.getAttribute("articleId");
        return JSON.toJSONString(newsService.selectByPk(id));
    }

    @RequestMapping("/changeByPk")
    public String changeByPk(int tmp,HttpSession session){
        session.setAttribute("articleId",tmp);
        return "redirect:/change-article.html";
    }
    @RequestMapping("/updateByPk")
    public String updateByPk(News news){
          newsService.updateByPk(news);
        return "redirect:/article-list.html";
    }
    @RequestMapping("/delOne")
    @ResponseBody
    public String delOne(int id){
        newsService.delOne(id);
        return JSON.toJSONString("success");
    }
    @RequestMapping("/selectByPk2")
    @ResponseBody
    public String selectByPk2(int id){
        News news=newsService.selectByPk(id);
        return JSON.toJSONString(news);
    }
    @RequestMapping("/sh")
    @ResponseBody
    public String sh(int id,int shstatus){
        newsService.sh(id,shstatus);
        return JSON.toJSONString("success");
    }
    @RequestMapping("/fbNews")
    @ResponseBody
    public String fbNews(int id,int fbstatus){
        newsService.fbNews(id,fbstatus);
        return JSON.toJSONString("success");
    }
    @RequestMapping("/selectNewsByAdmin")
    @ResponseBody
    public String selectNewsByAdmin(){
        List<News> list=newsService.selectNewsByAdmin();
        List list1=new ArrayList();
        for (News news:list) {
              if(news.getTitle().length()>=24){
                  news.setTitle(news.getTitle().substring(0,23)+"......");
              }
              list1.add(news);
        }
        return JSON.toJSONString(list1);
    }
    @RequestMapping("/selectNewsByStudent")
    @ResponseBody
    public String selectNewsByStudent(){
        List<News> list=newsService.selectNewsByStudent();
        List list1=new ArrayList();
        for (News news:list) {
            if(news.getTitle().length()>=24){
                news.setTitle(news.getTitle().substring(0,23)+"......");
            }
            list1.add(news);
        }
        return JSON.toJSONString(list1);
    }
}
