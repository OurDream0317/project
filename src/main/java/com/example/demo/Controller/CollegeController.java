package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.ClassModel;
import com.example.demo.model.College;
import com.example.demo.model.Profession;
import com.example.demo.service.CollegeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/college")
public class CollegeController {
    @Resource
    private CollegeService collegeService;
    @RequestMapping("/xyAll")
    @ResponseBody
    public String xyAll(){
       List<College> list= collegeService.seleceAll();
        return JSON.toJSONString(list);
    }
    @RequestMapping("/zyAll")
    @ResponseBody
    public String zyAll(){
        List<Profession> list= collegeService.seleceZYAll();
        return JSON.toJSONString(list);
    }
    @RequestMapping("/zyAll1")
    @ResponseBody
    public String zyAll1(int cid){
        List<Profession> list= collegeService.seleceZYAll1(cid);
        return JSON.toJSONString(list);
    }
    @RequestMapping("/claAll1")
    @ResponseBody
    public String classAll1(int classid){
        List<ClassModel> list= collegeService.seleceAllClass(classid);
        return JSON.toJSONString(list);
    }

}
