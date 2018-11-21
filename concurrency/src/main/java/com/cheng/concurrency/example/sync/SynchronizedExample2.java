package com.cheng.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cheng
 *         2018/11/21 17:21
 */
@Slf4j
public class SynchronizedExample2 {

    /**
     * 修饰一个类
     */
    public static void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    /**
     * 修饰一个静态方法
     */
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> test1(1));
        executorService.execute(() -> test1(2));

//        executorService.execute(() -> test2(1));
//        executorService.execute(() -> test2(2));
    }
}
