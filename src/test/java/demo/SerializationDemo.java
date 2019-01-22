package demo;

import org.junit.Test;

import java.io.*;

public class SerializationDemo implements Serializable{
    private String name;
    @Test
    public void method() throws IOException, ClassNotFoundException {
        SerializationDemo serializationDemo=new SerializationDemo();
        serializationDemo.name="我是序列化";
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File("G:/text.txt")));
        objectOutputStream.writeObject(serializationDemo);
        System.out.println("序列化成功");
       objectOutputStream.close();
        System.out.println("-----------------------------------------------");
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(new File("G:/text.txt")));
        SerializationDemo serializationDemo1= (SerializationDemo) objectInputStream.readObject();
        System.out.println("反序列化成功。。。");
    }
}
