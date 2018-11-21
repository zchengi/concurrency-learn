package com.cheng.concurrency.example.singleton;

import com.cheng.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * <p>
 * 单例实例在类装载时创建
 *
 * @author cheng
 *         2018/11/21 19:30
 */
@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2() { }

    private static SingletonExample2 instance = new SingletonExample2();

    /**
     * 静态工厂方法
     *
     * @return
     */
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
