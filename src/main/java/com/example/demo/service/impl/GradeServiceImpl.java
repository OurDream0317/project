package com.example.demo.service.impl;

import com.example.demo.mapper.GradeMapper;
import com.example.demo.model.Grade;
import com.example.demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public List<Grade> selectAllGrade(Grade grade) {
        Map map=new HashMap();
        map.put("grade",grade);
        return gradeMapper.selectAllGrade(map);
    }
}
