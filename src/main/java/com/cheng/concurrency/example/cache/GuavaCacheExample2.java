package com.cheng.concurrency.example.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Guava Cache
 *
 * @author cheng
 *         2018/11/30 18:11
 */
@Slf4j
public class GuavaCacheExample2 {

    public static void main(String[] args) {

        Cache<String, Integer> cache = CacheBuilder.newBuilder()
                .maximumSize(10) // 最多存放10个数据
                .expireAfterWrite(10, TimeUnit.SECONDS) // 缓存10s
                .recordStats() // 开启记录状态数据功能
                .build();

        log.info("{}", cache.getIfPresent("key1")); // null
        cache.put("key1", 1);
        log.info("{}", cache.getIfPresent("key1")); // 1
        cache.invalidate("key1");
        log.info("{}", cache.getIfPresent("key1")); // null

        try {
            log.info("{}", cache.get("key2", () -> -1)); // -1
            cache.put("key2", 2);
            log.info("{}", cache.get("key2", () -> -1)); // 2

            log.info("{}", cache.size()); // 1

            for (int i = 0; i < 13; i++) {
                cache.put("key" + i, i);
            }

            log.info("{}", cache.size()); // 10

            log.info("{}", cache.getIfPresent("key2")); // null

            Thread.sleep(11000);

            log.info("{}", cache.get("key5", () -> -1)); // -1

            log.info("{}, {}", cache.stats().hitCount(), cache.stats().missCount());

            log.info("{}, {}", cache.stats().hitRate(), cache.stats().missRate());
        } catch (Exception e) {
            log.error("cache exception", e);
        }
    }
}
