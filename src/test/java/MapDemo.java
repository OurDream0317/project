import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

    public void method() {
        Map map = new HashMap();
        map.put("wang", 1);
        map.put("wang1", 2);
        map.put("wang2", 3);
        map.put("wang3", 4);
        map.put("wang4", 5);
        map.put("wang5", 6);
        map.put("wang6", 7);
        System.out.println(map.size());
        for (Object in : map.keySet()) {
            System.out.println(in + "===========" + map.get(in));
        }
    }

    public void methodA() {
        Map map = new TreeMap();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        System.out.println(map.size());
        for (Object in : map.keySet()) {
            System.out.println(in + "===========" + map.get(in));
        }
    }

    public static void main(String[] args) {
        new MapDemo().methodA();
    }
}
