package com.example.demo.Controller;

import com.example.demo.service.DromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/drom")
public class DromController {
@Autowired
private DromService dromService;
@RequestMapping("/selectAll")
@ResponseBody
    public List selectAll(){
    List list=dromService.selectAll();
 return  list;
}
}
