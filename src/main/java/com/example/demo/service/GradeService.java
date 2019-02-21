package com.example.demo.service;


import com.example.demo.model.Grade;

import java.util.List;


public interface GradeService {
    public List<Grade> selectAllGrade(Grade grade);
}
