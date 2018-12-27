package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class DemoApplicationTests {
     static  String F="123";
    @Test
    public void contextLoads() {
    }
    @Test
    public void methodA(){
        String A="123";
        String B="123";
        String C="1"+"23";
        String D=new String("123");
        String E=new String("123");
        System.out.println(D==E);
        System.out.println(E==F);
    }

}
