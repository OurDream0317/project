package com.example.demo.service.impl;

import com.example.demo.mapper.GradeMapper;
import com.example.demo.model.Grade;
import com.example.demo.model.xzc;
import com.example.demo.service.GradeService;
import com.example.demo.util.GradeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "gradeService")
public class GradeServiceImpl implements GradeService {
    @Resource
    private GradeMapper gradeMapper;
    @Override
    public List selectAll(String sname, String snumber, String time1, String time2, int xy, int zy, int cla) {
        Map map=new HashMap();
        map.put("sname",sname);
        map.put("snumber",snumber);
        map.put("time1",time1);
        map.put("time2",time2);
        map.put("xy",xy);
        map.put("zy",zy);
        map.put("cla",cla);
        return gradeMapper.selectAll(map);
    }

}
