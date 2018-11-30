package com.cheng.concurrency.example.mq.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import javax.annotation.Resource;

/**
 * @author cheng
 *         2018/11/30 19:41
 */
//@Component
public class RabbitMQClient {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(QueueConstants.TEST, message);
    }
}
