package com.cheng.concurrency.example.syncContainer;

import com.cheng.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

/**
 * Vector 可能线程不安全
 *
 * @author cheng
 *         2018/11/22 18:36
 */
@Slf4j
@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        // 说明:
        // 当调用 vector.get(9); 时，线程1已经调用 vector.remove(9); 删除该元素，
        // 所以出现数组下标越界异常
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.get(i);
                }
            });

            thread1.start();
            thread2.start();
        }
    }
}
