package com.cheng.concurrency.example.singleton;

import com.cheng.concurrency.annotations.Recommend;
import com.cheng.concurrency.annotations.ThreadSafe;

/**
 * @author cheng
 *         2018/11/21 20:11
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7() {
    }

    public static SingletonExample7 getInstance() {
        return singleton.INSTANCE.getInstance();
    }

    private enum singleton {

        INSTANCE;

        private SingletonExample7 singleton;

        /**
         * JVM 保证这个方法绝对只调用一次
         */
        singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
