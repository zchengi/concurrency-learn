package com.cheng.concurrency.example.immutable;

import com.cheng.concurrency.annotations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;

/**
 * 不可变对象
 *
 * @author cheng
 *         2018/11/22 16:45
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private static final ImmutableList<Integer> LIST = ImmutableList.of(1, 2, 3);
//    private static final List<Integer> LIST = ImmutableList.of(1, 2, 3);

    private static final ImmutableSet<Integer> SET = ImmutableSet.copyOf(LIST);

    private static final ImmutableMap<Integer, Integer> MAP = ImmutableMap.of(1, 1, 2, 2, 3, 3);
    private static final ImmutableMap<Integer, Integer> MAP2 =
            ImmutableMap.<Integer, Integer>builder().put(1, 2).put(3, 4).put(5, 6).build();

    public static void main(String[] args) {

//        LIST.add(4);
//        SET.add(123);

//        MAP.put(4, 4);
//        MAP2.put(4, 4);

        System.out.println(MAP.get(3));
        System.out.println(MAP2.get(3));
    }
}
