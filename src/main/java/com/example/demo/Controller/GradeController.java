package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.College;
import com.example.demo.model.Grade;
import com.example.demo.service.CollegeService;
import com.example.demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public void selectALL(String sname, String snumber, String time1, String time2, int xy,int zy, int cla){
           System.out.println(sname+"++"+snumber+"++"+time1+"++"+time2+"++"+xy+"++"+zy+"++"+cla);
        List<Grade> list=gradeService.selectAll(sname,snumber,time1,time2,xy,zy,cla);
        System.out.println(JSON.toJSON(list));

       /*  return JSON.toJSONString(list);*/
             }
}
