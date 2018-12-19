package com.cheng.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join 框架
 *
 * @author cheng
 *         2018/11/23 18:30
 */
@Slf4j
public class ForkJoinTaskExample extends RecursiveTask<Integer> {

    private static final long serialVersionUID = -7769683052080862554L;

    private static final int threshold = 2;
    private int start, end;

    public ForkJoinTaskExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= threshold;
        if (canCompute) {
            // 如果任务足够小就计算任务
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阀值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            ForkJoinTaskExample leftTask = new ForkJoinTaskExample(start, middle);
            ForkJoinTaskExample rightTask = new ForkJoinTaskExample(middle + 1, end);

            // 执行子任务
            // fork方法相当于A先分工给B，然后A当监工不干活，B去完成A交代的任务
//            leftTask.fork();
//            rightTask.fork();

            // invokeAll相当于A分工给B后，A和B都去完成工作
            invokeAll(leftTask, rightTask);

            // 等待任务执行结束合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // 合并子任务
            sum = leftResult + rightResult;
        }

        return sum;
    }

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 生成一个计算任务，计算 1+2+3+4
        ForkJoinTaskExample task = new ForkJoinTaskExample(1, 100);

        // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);

        try {
            log.info("result: {}", result.get());
        } catch (Exception e) {
            log.error("exception", e);
        }
    }
}
