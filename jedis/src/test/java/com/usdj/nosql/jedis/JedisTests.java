package com.usdj.nosql.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author gerrydeng
 * @date 2019-07-23 15:45
 * @Description:
 */
public class JedisTests {

    @Test
    public void test01(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("one", "hello");
        System.out.println(jedis.get("one"));
        jedis.close();
    }

    @Test
    public void test02(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(30);
        jedisPoolConfig.setMaxIdle(10);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("two", "world");
        System.out.println(jedis.get("two"));
        jedis.close();
        jedisPool.close();


    }
}
