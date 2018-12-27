package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class TestDemo {


    public static void main(String[] args) {
        List list1=new ArrayList();
        list1.add("wang");
        list1.add("wei");
        list1.add("xiang");
        list1.add("wang");
        list1.add("rourou");
        Stream stream=list1.stream().distinct();
        System.out.println(JSON.toJSONString(stream));

    }
    @Test
    public void method() {
        List<List> lists = new ArrayList<>();
        List list = new ArrayList();
        list.add("郑州");
        list.add("商丘");
        list.add("洛阳");
        list.add("开封");
        lists.add(list);
        List list1 = new ArrayList();
        list1.add("济南");
        list1.add("济宁");
        list1.add("青岛");
        list1.add("日照");
        lists.add(list1);
        System.out.println(lists);
    }
}
