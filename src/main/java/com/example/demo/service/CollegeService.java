package com.example.demo.service;

import com.example.demo.model.ClassModel;
import com.example.demo.model.College;
import com.example.demo.model.Profession;


import java.util.List;

public interface CollegeService {
    public List seleceAll();
    public List seleceZYAll();
    public List seleceZYAll1(int cid);
    public List<ClassModel> seleceAllClass(int classid);
}
