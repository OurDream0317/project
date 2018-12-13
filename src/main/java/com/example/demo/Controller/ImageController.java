package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Image;
import com.example.demo.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Resource
    private ImageService imageService;
    @RequestMapping("/addimg")
    public String addimage(Image image, MultipartFile file){
        System.out.println(file.getOriginalFilename());
        imageService.addimage(image,file);
        return "redirect:/picture-list.html";
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    public String selectAll(){
        List list=imageService.selectAll();
        return JSON.toJSONString(list);
    }
}