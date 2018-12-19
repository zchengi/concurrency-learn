package com.cheng.concurrency.example.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * jps
 * top -Hp pid
 * jstack PID
 *
 * @author cheng
 *         2018/12/19 16:45
 */
@Slf4j
public class SearchBusiestCPU {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
            }).start();
        }

        Thread thread = new Thread(() -> {
            int i = 0;
            while (true) {
                i = (i++) / 100;
            }
        });

        thread.setName("Busiest thread");
        thread.start();
    }
}
