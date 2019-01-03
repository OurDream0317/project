package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Drom;
import com.example.demo.service.CollegeService;
import com.example.demo.service.DromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

      System.out.println(type+"+"+number+"+"+floor+"+"+number1);

     List list=dromService.selectDrom(type,number,floor,number1);
    return list;

    }
}
