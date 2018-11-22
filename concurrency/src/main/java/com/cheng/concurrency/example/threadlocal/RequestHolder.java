package com.cheng.concurrency.example.threadlocal;

/**
 * 线程封闭 - ThreadLocal
 *
 * @author cheng
 *         2018/11/22 17:25
 */
public class RequestHolder {

    private static final ThreadLocal<Long> REQUEST_HOLDER = new ThreadLocal<>();

    public static void add(Long id) {
        REQUEST_HOLDER.set(id);
    }

    public static Long getId() {
        return REQUEST_HOLDER.get();
    }

    public static void remove() {
        REQUEST_HOLDER.remove();
    }
}
