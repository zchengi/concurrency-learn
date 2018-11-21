package com.cheng.concurrency.example.singleton;

import com.cheng.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式 -> 双重同步锁单例模式
 * <p>
 * 单例实例在第一次使用的时候创建
 *
 * @author cheng
 *         2018/11/21 20:05
 */
@ThreadSafe
public class SingletonExample5 {

    private SingletonExample5() { }

    /**
     * 单例模式 volatile + 双重检测机制 -> 禁止指令重排
     */
    private volatile static SingletonExample5 instance = null;

    /**
     * 静态工厂方法
     * <p>
     * 1. memory = allocate() 分配对象的内存空间
     * 2. ctorInstance() 初始化对象
     * 3. instance = memory 设置 instance 指向刚分配的内存
     * <p>
     *
     * @return
     */
    public static SingletonExample5 getInstance() {

        // 双重检测机制
        if (instance == null) {
            // 同步锁
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }

        return instance;
    }
}
