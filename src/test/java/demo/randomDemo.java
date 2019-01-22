package demo;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

import java.util.Random;

public class randomDemo {
    @Test
    public void method(){
        String pwd="123456";
        Random random=new Random();
       String salt=String.valueOf(random.nextInt(9)+1)+String.valueOf(random.nextInt(9)+1)+String.valueOf(random.nextInt(9)+1);
       String newPwd=new SimpleHash("MD5",pwd,"123",1).toString();
       System.out.println(pwd+"1次加密后为："+newPwd+"========="+"2次加密后为："+new SimpleHash("MD5",pwd,"123",2).toString());
    }
}
