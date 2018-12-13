package com.example.demo.service;

import com.example.demo.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ImageService {
    public void addimage(Image image, MultipartFile file);
    public List selectAll();
}
