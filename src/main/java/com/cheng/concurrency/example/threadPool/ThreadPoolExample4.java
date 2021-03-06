package com.cheng.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池 Executors.newScheduledThreadPool
 *
 * @author cheng
 *         2018/11/26 21:59
 */
@Slf4j
public class ThreadPoolExample4 {
    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        /*for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> log.info("task: {}", index));
        }*/

//        executorService.schedule(() -> log.warn("schedule  run"), 3, TimeUnit.SECONDS);

        // 延迟 1s 每隔 3s 一直执行任务，
        executorService.scheduleAtFixedRate(() -> log.warn("schedule  run"), 1, 3, TimeUnit.SECONDS);


        // 定时执行任务
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("time run");
            }
        }, new Date(),5*1000);

//        executorService.shutdown();
    }
}
