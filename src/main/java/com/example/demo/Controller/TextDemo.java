package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TextDemo {
    @RequestMapping("/login")
    public String text(){
        System.out.println("1111111111111");
        return "login";
    }
    @RequestMapping("/index")
    public String text1(){

        return "login";
    }
}
