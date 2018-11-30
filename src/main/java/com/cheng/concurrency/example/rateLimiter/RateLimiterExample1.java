package com.cheng.concurrency.example.rateLimiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author cheng
 *         2018/11/30 20:38
 */
@Slf4j
public class RateLimiterExample1 {

    private static RateLimiter rateLimiter = RateLimiter.create(5);

    public static void main(String[] args) {

        for (int index = 0; index < 100; index++) {
            if (rateLimiter.tryAcquire(190, TimeUnit.MILLISECONDS)) {
                handle(index);
            }
        }
    }

    private static void handle(int i) {
        log.info("{}", i);
    }
}
