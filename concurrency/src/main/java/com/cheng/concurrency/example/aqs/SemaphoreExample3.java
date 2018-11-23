package com.cheng.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore: 尝试获取许可
 *
 * @author cheng
 *         2018/11/23 17:04
 */
@Slf4j
public class SemaphoreExample3 {

    private static final int THREAD_COUNT = 200;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        // 这里只输出三条日志，因为 Semaphore 在同一时间只能获取三个许可，获取不到许可的线程就被丢弃了
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    // 尝试获取许可
                    if (semaphore.tryAcquire()) {
                        test(threadNum);
                        // 释放一个许可
                        semaphore.release(3);
                    }
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
