package com.cheng.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author cheng
 *         2018/11/30 17:37
 */
@Configuration
public class RedisConfig {

    @Bean(name = "redisPool")
    public JedisPool jedisPool(
                               @Value("${jedis.host}") String host,
                               @Value("${jedis.port}") int port,
                               @Value("${jedis.timeout}") int timeout,
                               @Value("${jedis.password}") String password) {
        return new JedisPool(new JedisPoolConfig(), host, port, timeout, password);
    }
}
