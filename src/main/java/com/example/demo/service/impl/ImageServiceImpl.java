package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.ImageMapper;
import com.example.demo.model.Image;
import com.example.demo.model.Student;
import com.example.demo.service.ImageService;
import com.example.demo.util.UpFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "imageService")
public class ImageServiceImpl implements ImageService {
    @Resource
    private ImageMapper imageMapper;

    @Override
    public void addimage(Image image, MultipartFile file) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String data = df.format(new Date());
        image.setItime(data);
        if (!file.isEmpty()) {
            new UpFile().addNewsDemo(file);
            image.setIurl("img/" + file.getOriginalFilename());
        }
        Map map = new HashMap();
        map.put("image", image);
        imageMapper.addimage(map);
    }

    @Override
    public List selectAll() {
        return imageMapper.selectAll();
    }

    @Override
    public void updateStatus(int id, int istatus) {
        imageMapper.updateStatus(id, istatus);
    }

    @Override
    public List selectStatus() {
        List list = imageMapper.selectStatus();
        return list;
    }

    @Override
    public List selectStatus2() {
        List list = imageMapper.selectStatus();
        if (list.size() < 4) {
            List list1 = imageMapper.selectStatus1(4 - list.size());
            list.addAll(list1);
            return list;
        }
        return list;
    }

    @Override
    public void delOne(int id) {
        imageMapper.delOne(id);
    }

    @Override
    public Image selectById(int id) {
        return imageMapper.selectById(id);
    }

    @Override
    public void updateOne2(Image image, MultipartFile file) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String data = df.format(new Date());
        image.setItime(data);
        if (!file.isEmpty()) {
            new UpFile().addNewsDemo(file);
            image.setIurl("img/" + file.getOriginalFilename());
        }
        Map map = new HashMap();
        map.put("image", image);
        imageMapper.updateOne2(map);
    }

    @Override
    public void delAll(String[] item) {
        imageMapper.delAll(item);
    }

    @Override
    public List<Image> selectByBtn(String min, String max, String Myitype) {
      return   imageMapper.selectByBtn(min,max,Myitype);
    }

}
