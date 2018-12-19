package com.cheng.concurrency.example.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * 3. 创建线程导致内存溢出
 * 在 windows 平台的虚拟机中，Java 的线程是映射到操作系统的内核线程上，可能导致机器假死
 *
 * @author cheng
 *         2018/12/19 16:35
 */
@Slf4j
public class JavaVMStackOOM {

    private void doStop() {
        while (true) {
        }
    }

    private void stackLeakByThread() {
        while (true) {
            new Thread(this::doStop).start();
        }
    }

    public static void main(String[] args) {

        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
