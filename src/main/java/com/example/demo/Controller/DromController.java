package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Drom;
import com.example.demo.service.CollegeService;
import com.example.demo.service.DromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthScrollBarUI;
import java.util.List;

@Controller
@RequestMapping("/drom")
public class DromController {
    @Autowired
    private DromService dromService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List selectAll() {
        List list = dromService.selectAll();
        return list;
    }

    @RequestMapping("/adddrom")
    public String addDrom(Drom drom) {
        System.out.println(JSON.toJSON(drom));
        dromService.addDrom(drom);
        return "redirect:/drom-list.html";

    }

    @RequestMapping("/selectDrom")
    @ResponseBody
    public List selectDrom(String type,String number,String floor,String number1) {
     List list=dromService.selectDrom(type,number,floor,number1);
    return list;

    }
    @RequestMapping("/selectDromOne")
    @ResponseBody
    public String selectDromOne(String dtype,String dnumber1){
        if(dromService.selectDromOne(dtype,dnumber1)!=null) {
            return dtype+" "+dnumber1+" "+"已存在！";
        }
        return "";
    }
    @RequestMapping("/updateDrom")
    public String updateDrom( int id,HttpSession session){
       session.setAttribute("id",id);
       return "redirect:/drom-list.html";
    }
    @RequestMapping("/updateDromOne")
    @ResponseBody
    public String updateDromOne(HttpSession session){
        int id= (int) session.getAttribute("id");
        Drom drom=dromService.selectDromDemo(id);
        return JSON.toJSONString(drom);
    }
    @RequestMapping("/updatedrom")
    public String updatedrom(Drom drom,HttpSession session){
        int id= (int) session.getAttribute("id");
        drom.setId(id);
          dromService.updatedrom(drom);
          System.out.println(JSON.toJSONString(drom));
        return "redirect:/drom-list.html";
    }
}
