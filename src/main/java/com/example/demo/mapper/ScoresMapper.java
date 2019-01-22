package com.example.demo.mapper;

import com.example.demo.model.Scores;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ScoresMapper {
  public List selectAllScores();
  void addScore(Map map);
}