package com.cheng.concurrency.example.jvm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. 方法和运行时常量池溢出
 *
 * @author cheng
 *         2018/12/19 16:41
 */
@Slf4j
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
