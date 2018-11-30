package com.cheng.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池 Executors.newFixedThreadPool
 *
 * @author cheng
 *         2018/11/26 21:58
 */
@Slf4j
public class ThreadPoolExample2 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> log.info("task: {}" ,index));
        }

        executorService.shutdown();
    }
}
