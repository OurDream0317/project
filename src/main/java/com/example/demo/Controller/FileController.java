package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/file")
public class FileController {
@RequestMapping("/up")
    public void fileUp(MultipartFile file, HttpServletRequest request){
        System.out.println(file.getOriginalFilename());
        System.out.println(request.getContextPath());
    }
    @RequestMapping("/upfile")
    @ResponseBody
    public String fileUp(String str) {
        System.out.println(str);
        return str;
    }
}
