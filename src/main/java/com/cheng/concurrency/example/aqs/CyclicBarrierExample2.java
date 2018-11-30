package com.cheng.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * CyclicBarrier
 *
 * @author cheng
 *         2018/11/23 17:25
 */
@Slf4j
public class CyclicBarrierExample2 {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }

        executor.shutdown();
    }

    private static void race(int threadNum) throws Exception {

        Thread.sleep(1000);
        log.info("{} is ready" + threadNum);

        try {
            barrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            log.warn("InterruptedException", e);
        } catch (BrokenBarrierException e) {
            log.warn("BrokenBarrierException", e);
        } catch (TimeoutException e) {
            log.warn("TimeoutException", e);
        }

        log.info("{} is continue", threadNum);
    }
}
