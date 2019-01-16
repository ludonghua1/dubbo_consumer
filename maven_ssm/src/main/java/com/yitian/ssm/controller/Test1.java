package com.yitian.ssm.controller;


import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test1 {
//    public static void main(String[] args) {
//        Set<HostAndPort> jedisClusterNodes = new HashSet();
//        jedisClusterNodes.add(new HostAndPort("192.168.199.134", 7000));
//        jedisClusterNodes.add(new HostAndPort("192.168.199.134", 7001));
//        jedisClusterNodes.add(new HostAndPort("192.168.199.134", 7002));
//        jedisClusterNodes.add(new HostAndPort("192.168.199.134", 7003));
//        jedisClusterNodes.add(new HostAndPort("192.168.199.134", 7004));
//        jedisClusterNodes.add(new HostAndPort("192.168.199.134", 7005));
//        //根据节点集创集群链接对象
//        JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
////    /*Map map=new HashMap();
////    map.put("7","2018-12-28 08:30:00");
////    map.put("8","2018-12-28 08:30:00");
////    map.put("21","2018-12-28 08:30:00");
////    map.put("22","2018-12-28 08:30:00");
////    map.put("23","2018-12-28 08:30:00");
////    jedisCluster.hmset("flashSale",map);*/
////        for (int i = 1; i <= 2; i++) {
////            jedisCluster.rpush("list:7", i + "");
////        }
////    }

}
