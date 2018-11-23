package com.cheng.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore: 获取多个许可
 *
 * @author cheng
 *         2018/11/23 17:03
 */
@Slf4j
public class SemaphoreExample2 {

    private static final int THREAD_COUNT = 200;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    // 获取多个许可
                    semaphore.acquire(3);
                    test(threadNum);
                    // 释放多个许可
                    semaphore.release(3);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }

        log.info("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
