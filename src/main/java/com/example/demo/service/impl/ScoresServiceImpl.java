package com.example.demo.service.impl;

import com.example.demo.mapper.ScoresMapper;
import com.example.demo.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "scoresService")
public class ScoresServiceImpl implements ScoresService {
    @Resource
    private ScoresMapper scoresMapper;
    @Override
    public List selectAllScores() {
          return scoresMapper.selectAllScores();
    }
}
