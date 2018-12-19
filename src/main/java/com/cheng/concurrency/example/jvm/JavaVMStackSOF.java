package com.cheng.concurrency.example.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * 2. 虚拟机和本地方法栈溢出
 *
 * @author cheng
 *         2018/12/19 16:31
 */
@Slf4j
public class JavaVMStackSOF {

    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {

        JavaVMStackSOF stackSOF = new JavaVMStackSOF();

        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            log.error("Stack length: {}", stackSOF.stackLength);
            throw e;
        }
    }
}
