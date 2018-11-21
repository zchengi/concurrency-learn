package com.cheng.concurrency.example.singleton;

import com.cheng.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * <p>
 * 单例实例在类装载时创建
 *
 * @author cheng
 *         2018/11/21 20:08
 */
@ThreadSafe
public class SingletonExample6 {

    private SingletonExample6() { }

    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    /**
     * 静态工厂方法
     *
     * @return
     */
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {

        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
