package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Scores;
import com.example.demo.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@Controller
@RequestMapping("/scores")
public class ScoresController {
    @Autowired
    private ScoresService scoresService;
@RequestMapping("/selectAll")
@ResponseBody
public String selectAllScores(){
     List list=scoresService.selectAllScores();
    return JSON.toJSONString(list);
}
    @RequestMapping("/addScore")
    public String addScore(Scores scores, MultipartFile file){
    scoresService.addScore(scores,file);
        return "redirect:/coures-list.html";
    }
}
