package demo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class demo02 {
    @Test
    public  void method(){
        Map map=new HashMap();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);
        System.out.println(map.toString().substring(1,map.toString().length()-1));
    }
}
