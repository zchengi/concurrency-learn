package com.cheng.concurrency.example.blockingQueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 *
 * @author cheng
 *         2018/12/19 16:06
 */
@Slf4j
public class BlockingQueueExample1 {

    public static void main(String[] args) {

        final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                    log.info("{} 准备放数据!", Thread.currentThread().getName());
                    blockingQueue.put(1);
                    log.info("{} 已经放了数据，队列目前有 {} 个数据", Thread.currentThread().getName(), blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        new Thread(() -> {
            while (true) {
                try {
                    // 将此处的睡眠时间分别改为 100 和 1000，观察运行结果
                    Thread.sleep(100);
                    log.info("{} 准备取数据!", Thread.currentThread().getName());
                    blockingQueue.take();
                    log.info("{} 已经取走数据，队列目前有 {} 个数据", Thread.currentThread().getName(), blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
