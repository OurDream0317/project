package demo;

import com.example.demo.util.RandomCodeDemo;
import org.junit.Test;

import java.util.Random;

public class demo01 implements Runnable {
    public String name;
    public demo01(String name){
        this.name=name;
    }

    @Override
    public void run() {
        int i=10;
        while (i>0) {
            System.out.println(name+"====="+i);
            i--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new demo01("A"));
        Thread thread1=new Thread(new demo01("B"));
        System.out.println("begin:" + thread1.isAlive());
        thread1.start();
        thread1.join();
        System.out.println("end:" + thread1.isAlive());
    }

}
