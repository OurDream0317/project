package com.example.demo.service;

import com.example.demo.model.Image;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    public void addimage(Image image, MultipartFile file);

    public List selectAll();

    public void updateStatus(int id, int istatus);

    public List selectStatus();

    public List selectStatus2();

    void delOne(int id);

    Image selectById(int id);
    public void updateOne2(Image image, MultipartFile file);
    void delAll(String[] item);
    List<Image> selectByBtn( String min, String max,String Myitype);
}
