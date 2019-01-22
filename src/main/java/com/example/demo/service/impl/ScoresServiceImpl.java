package com.example.demo.service.impl;

import com.example.demo.mapper.ScoresMapper;
import com.example.demo.model.Scores;
import com.example.demo.service.ScoresService;
import com.example.demo.util.UpFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "scoresService")
public class ScoresServiceImpl implements ScoresService {
    @Resource
    private ScoresMapper scoresMapper;
    @Override
    public List selectAllScores() {
          return scoresMapper.selectAllScores();
    }

    @Override
    public void addScore(Scores scores, MultipartFile file) {
        new UpFile().addNewsDemo(file);
        scores.setSurl("/img/"+file.getOriginalFilename());
        Map map=new HashMap();
        map.put("scores",scores);
        scoresMapper.addScore(map);
    }
}
