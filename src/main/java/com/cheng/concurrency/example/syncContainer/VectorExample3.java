package com.cheng.concurrency.example.syncContainer;

import com.cheng.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author cheng
 *         2018/11/22 18:36
 */
@Slf4j
@NotThreadSafe
public class VectorExample3 {

    /**
     * java.util.ConcurrentModificationException
     */
    private static void test1(Vector<Integer> vector) {
        for (Integer i : vector) {
            if (i.equals(3)) {
                vector.remove(i);
            }
        }
    }

    /**
     * java.util.ConcurrentModificationException
     */
    private static void test2(Vector<Integer> vector) {
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                vector.remove(i);
            }
        }
    }

    /**
     * success
     */
    private static void test3(Vector<Integer> vector) {
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i).equals(3)) {
                vector.remove(i);
            }
        }
    }

    /**
     * java.util.ConcurrentModificationException
     */
    private static void test4(Vector<Integer> vector) {
        vector.forEach(i -> {
            if (i.equals(3)) {
                vector.remove(i);
            }
        });
    }

    public static void main(String[] args) {

        /*
         *
         * 遍历中调用删除操作，会出现并发错误，解决方案：
         *
         * 1. 标记要删除的位置，循环完后再删除
         * 2. 使用 for 循环
         * 3. 使用 synchronized 或 Lock 对 iterator 做同步措施
         * 4. 使用并发容器 CopyOnWriteArrayList ... 代替 ArrayList/Vector
         *
         */

        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

//        test1(vector);
//        test2(vector);
        test3(vector);
//        test4(vector);
    }
}
