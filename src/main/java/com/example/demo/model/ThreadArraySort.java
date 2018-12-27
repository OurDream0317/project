package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadArraySort implements Runnable {

    private Integer num;

    public ThreadArraySort(Integer num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(num);
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {120,100,80,50,30,500,300,400};
        List<Integer> integers = Arrays.asList(nums);
//        integers.forEach(num -> new Thread(new ThreadArraySort(num)).start());
//        integers.stream().filter(num->num!=50).map(num->2*num).forEach(num-> System.out.println(num));

        Math math = (a, b) ->{
            System.out.println(a + " " + b);

        } ;

        math.desc(1,2);
//        int desc = math.desc(10, 20);
//       System.out.println(desc);
    }
}
