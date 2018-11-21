package com.cheng.concurrency.example.singleton;

import com.cheng.concurrency.annotations.NotThreadSafe;

/**
 * 懒汉模式
 * <p>
 * 单例实例在第一次使用的时候创建
 *
 * @author cheng
 *         2018/11/21 19:27
 */
@NotThreadSafe
public class SingletonExample1 {

    private SingletonExample1() { }

    private static SingletonExample1 instance = null;

    /**
     * 静态工厂方法
     *
     * @return
     */
    public static SingletonExample1 getInstance() {

        if (instance == null) {
            instance = new SingletonExample1();
        }

        return instance;
    }
}
