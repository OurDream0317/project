package com.example.demo.service.impl;

import com.example.demo.mapper.DromMapper;
import com.example.demo.model.Drom;
import com.example.demo.service.DromService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "dromService")
public class DromServiceImpl implements DromService {
     @Resource
     private RedisTemplate redisTemplate;
     @Resource
     private DromMapper dromMapper;
    @Override
    public List selectAll() {
        redisTemplate.delete("list");
        List list1 = (List) redisTemplate.opsForList().leftPop("list");
        if(list1==null){
            list1=dromMapper.selectAll();
            redisTemplate.opsForList().leftPush("list",list1);
        }else{
        return  list1;
        }
        return list1;
    }

    @Override
    public void addDrom(Drom drom) {
        Map map=new HashMap();
        map.put("drom",drom);
        dromMapper.addDrom(map);
    }

    @Override
    public List selectDrom(String type, String number, String floor, String number1) {
        System.out.println(type+" +"+number+" +"+floor+"+ "+number1);
        Map map=new HashMap();
        map.put("type",type);
        map.put("number","%"+number+"%");
        map.put("floor","%"+floor+"%");
        map.put("number1","%"+number1+"%");
      return dromMapper.selectDrom(map);
    }

    @Override
    public Drom selectDromOne(String dtype,String dnumber1) {
        return dromMapper.selectDromOne(dtype,dnumber1);
    }

    @Override
    public Drom selectDromDemo(int id) {
       return dromMapper.selectDromDemo(id);
    }

    @Override
    public void updatedrom(Drom drom) {
        Map map=new HashMap();
        map.put("drom",drom);
        dromMapper.updatedrom(map);
    }

    @Override
    public void delAll(String[] ids) {
        dromMapper.delAll(ids);
    }

    @Override
    public void delOne(int id) {
        dromMapper.delOne(id);
    }
}
