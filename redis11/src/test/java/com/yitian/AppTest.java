package com.yitian;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
//        Jedis jedis = new Jedis("127.0.0.1",6379);
//        jedis.auth("123456");
//        System.out.println(jedis.get("test"));
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        JedisPool pool = new JedisPool(config,"127.0.0.1",6379);
        Jedis jedis = pool.getResource();
        jedis.auth("123456");
        System.out.println(jedis.get("test"));
    }
}
