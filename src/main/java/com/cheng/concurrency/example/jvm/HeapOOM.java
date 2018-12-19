package com.cheng.concurrency.example.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Java 堆溢出
 * <p>
 * -Xms20M -Xmx20M
 *
 * @author cheng
 *         2018/12/19 16:24
 */
public class HeapOOM {

    private static class OOMObject {}

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
