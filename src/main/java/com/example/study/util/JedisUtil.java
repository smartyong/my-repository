package com.example.study.util;

import redis.clients.jedis.Jedis;

public class JedisUtil {

    public static Jedis JedisUtil(){
        Jedis jedis=new Jedis("127.0.0.1", 6379);
        return jedis;
    }

    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1", 6379);
        String s = jedis.set("mykey", "my", "nx", "ex", 5);
        System.out.println(s);
        jedis.close();
    }
}
