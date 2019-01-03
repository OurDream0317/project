package com.example.demo.service.impl;

import com.example.demo.mapper.CollegeMapper;
import com.example.demo.model.ClassModel;
import com.example.demo.model.College;
import com.example.demo.model.Profession;
import com.example.demo.service.CollegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service( "collegeService")
public class CollegeServiceImpl implements CollegeService {
    @Resource
    private CollegeMapper collegeMapper;
    @Override
    public List seleceAll() {
        List<College> list=collegeMapper.seleceAllXY();
        return list;
    }

    @Override
    public List seleceZYAll() {
        List list=collegeMapper.seleceAllZY();
        return list;
    }

    @Override
    public List seleceZYAll1(int cid) {
        List list=collegeMapper.seleceAllZY1(cid);
        return list;
    }

    @Override
    public List<ClassModel> seleceAllClass(int classid) {
        List list=collegeMapper.seleceAllClass(classid);
        return list;
    }

}
