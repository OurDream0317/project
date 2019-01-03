package com.example.demo.util;

import java.util.Random;


/**
 * java生成一个4位的随机数（验证码）
 * @author Administrator
 *
 */
public class RandomCodeDemo {

    public static String randomdemo() {
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb=new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        System.out.println(sb.toString());

        return sb.toString();
    }


}