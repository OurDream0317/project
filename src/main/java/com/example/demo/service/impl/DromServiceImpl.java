package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.DromMapper;
import com.example.demo.service.DromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "dromService")
public class DromServiceImpl implements DromService {
     @Resource
     private RedisTemplate redisTemplate;
     @Resource
     private DromMapper dromMapper;
    @Override
    public List selectAll() {
        List list1 = (List) redisTemplate.opsForList().leftPop("list");
        if(list1==null){
            list1=dromMapper.selectAll();
            redisTemplate.opsForList().leftPush("list",list1);
        }else{
        return  list1;
        }

        return null;

    }
}
