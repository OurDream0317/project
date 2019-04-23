package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Image;
import com.example.demo.model.Student;
import com.example.demo.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Resource
    private ImageService imageService;
    @RequestMapping("/addimg")
    public String addimage(Image image, MultipartFile file,HttpSession session){
        Student student= (Student) session.getAttribute("student");
        image.setIauthor(student.getSname());
        imageService.addimage(image,file);
        return "redirect:/picture-list.html";
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    public String selectAll(){
        List list=imageService.selectAll();
        return JSON.toJSONString(list);
    }
    @RequestMapping("/updateStatus")
    public String updateStatus(int id,int istatus){
        imageService.updateStatus(id,istatus);
        return "redirect:/picture-list.html";
    }
    @RequestMapping("/selectStatus")
    @ResponseBody
    public String selectStatus(){
        List list=imageService.selectStatus();
        return JSON.toJSONString(list);
    }
    @RequestMapping("/selectStatus2")
    @ResponseBody
    public String selectStatus2(){
        List list=imageService.selectStatus2();
        return JSON.toJSONString(list);
    }
    @RequestMapping("/delOne")
    @ResponseBody
    public String delOne(int id){
        imageService.delOne(id);
        return JSON.toJSONString("success");
    }
    @RequestMapping("/updateOne1")
    @ResponseBody
    public String updateOne1(HttpSession session){
        int id= (int) session.getAttribute("imageId");
        Image image=imageService.selectById(id);
        return JSON.toJSONString(image);
    }
    @RequestMapping("/updateOne")
    public String updateOne(int id,HttpSession session){
       session.setAttribute("imageId",id);
        return "redirect:/picture-update.html";
    }
    @RequestMapping("/updateOne2")
    public String updateOne2(Image image, MultipartFile file){
        imageService.updateOne2(image,file);
        return "redirect:/picture-list.html";
    }
    @RequestMapping("/delAll")
    @ResponseBody
    public String delAll(String[] ids){
       imageService.delAll(ids);
        return JSON.toJSONString("success");
    }
    //模糊查询
    @RequestMapping("/selectByBtn")
    @ResponseBody
    public String selectByBtn(String min,String max,String Myitype){
       List<Image> list= imageService.selectByBtn(min,max,Myitype);
        return JSON.toJSONString(list);
    }
}
