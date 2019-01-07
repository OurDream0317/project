package com.example.demo.service;

import com.example.demo.model.ClassModel;
import com.example.demo.model.College;
import com.example.demo.model.Profession;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface CollegeService {
    public List seleceAll();
    public List seleceZYAll();
    public List seleceZYAll1(int cid);
    public List<ClassModel> seleceAllClass(int classid);
    College selectxyname(int id);
    public Profession selectzyname( int id);
    public ClassModel selectclaname( int id);
}
