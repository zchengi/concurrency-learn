package com.cheng.concurrency.example.mq;

import lombok.Data;

import java.util.Date;

/**
 * @author cheng
 *         2018/11/30 19:25
 */
@Data
public class Message {

    private Long id;

    private String message;

    private Date sendTime;
}
