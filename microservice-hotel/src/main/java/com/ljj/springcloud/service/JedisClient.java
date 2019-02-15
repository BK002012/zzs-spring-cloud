package com.ljj.springcloud.service;

import java.util.List;

/**
 * @param
 * @Author: HJ
 * @Time: 上午12:00 19-1-8
 * @version: v1.0
 */
public interface JedisClient {
    //string
    String get(String key);
    String set(String key, String value);
    Boolean exists(String key);
    Long expire(String key, int seconds);
    Long ttl(String key);
    Long incr(String key);
    Long del(String key);

    //hash
    String hget(String key, String field);
    Long hset(String key, String field, String value);
    String hdel(String key, String... field);
    Boolean hexists(String key, String field);
    List<String> values(String key);

    //list
    Long lpush(String key, String... Strings);
    List<String> lrange(String key, long start, long end);
}
