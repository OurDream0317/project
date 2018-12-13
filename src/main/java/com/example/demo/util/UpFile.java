package com.example.demo.util;


import org.apache.commons.io.IOUtils;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/10 0010.
 */
public class UpFile {
    public void addNewsDemo(MultipartFile file1) {
        System.out.println(file1.getOriginalFilename()+"555555555555555");
        String path1= ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/img"+"/"+file1.getOriginalFilename();
        // shop.setShopPacking();
        File target1 = new File(path1);
        OutputStream out1=null;
        try {
            out1 = new FileOutputStream(target1);
            try {
                IOUtils.copy(file1.getInputStream(), out1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                out1.close();
            } catch (IOException e) {

            }

        }

    }
}
