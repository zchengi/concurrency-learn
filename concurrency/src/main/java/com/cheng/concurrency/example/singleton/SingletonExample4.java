package com.cheng.concurrency.example.singleton;

import com.cheng.concurrency.annotations.NotThreadSafe;

/**
 * 懒汉模式 -> 双重同步锁单例模式
 * <p>
 * 单例实例在第一次使用的时候创建
 *
 * @author cheng
 *         2018/11/21 19:59
 */
@NotThreadSafe
public class SingletonExample4 {

    private SingletonExample4() { }

    private static SingletonExample4 instance = null;

    /**
     * 静态工厂方法
     * <p>
     * 1. memory = allocate() 分配对象的内存空间
     * 2. ctorInstance() 初始化对象
     * 3. instance = memory 设置 instance 指向刚分配的内存
     * <p>
     * 多线程情况下 JVM 和 cpu 优化，发生了指令重排：
     * 1. memory = allocate() 分配对象的内存空间
     * 3. instance = memory 设置 instance 指向刚分配的内存
     * 2. ctorInstance() 初始化对象
     *
     * @return
     */
    public static SingletonExample4 getInstance() {

        // 双重检测机制
        if (instance == null) {
            // 同步锁
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }

        return instance;
    }
}
