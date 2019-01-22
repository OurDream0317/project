package com.example.demo.service;

import com.example.demo.model.Scores;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ScoresService {
    public List selectAllScores();
    void addScore(Scores scores, MultipartFile file);
}
