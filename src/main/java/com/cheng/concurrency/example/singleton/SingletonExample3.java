package com.cheng.concurrency.example.singleton;

import com.cheng.concurrency.annotations.NotRecommend;
import com.cheng.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * <p>
 * 单例实例在第一次使用的时候创建
 *
 * @author cheng
 *         2018/11/21 19:58
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private SingletonExample3() { }

    private static SingletonExample3 instance = null;

    /**
     * 静态工厂方法
     *
     * @return
     */
    public static synchronized SingletonExample3 getInstance() {

        if (instance == null) {
            instance = new SingletonExample3();
        }

        return instance;
    }
}
