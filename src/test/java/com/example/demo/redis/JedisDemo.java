package com.example.demo.redis;

import redis.clients.jedis.Jedis;

public class JedisDemo {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.set("1","wang");
        System.out.println(jedis.get("1"));
    }

}
