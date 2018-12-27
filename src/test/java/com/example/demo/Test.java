package com.example.demo;

import com.aliyuncs.exceptions.ClientException;
import com.example.demo.util.SmsUtil;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
    @org.junit.Test
    public void method() {
        SmsUtil smsUtil = new SmsUtil();
        try {
            smsUtil.sendSms("15239932660", "SMS_144150302", "GR品优购", "{\\\"code\\\":\\\"\"+111111+\"\\\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void methodA() {
        long midTime = new Date().getTime();
            while(midTime>0){


                long hh = midTime / 60 / 60 % 60;

                long mm = midTime / 60 % 60;

                long ss = midTime % 60;

                System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
                try {
                    Thread.sleep(1000);
                    midTime--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }
}


