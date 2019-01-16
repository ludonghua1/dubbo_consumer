package com.yitian.ldh.cache;

import com.yitian.ldh.controller.EmailThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;


public class RedisCacheTransfer {

    @Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
    @Autowired
    public void setMailSender(JavaMailSenderImpl mailSender){
        EmailThread.setMailSender(mailSender);
    }

}
