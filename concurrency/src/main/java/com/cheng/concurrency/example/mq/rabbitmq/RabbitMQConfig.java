package com.cheng.concurrency.example.mq.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;


/**
 * @author cheng
 *         2018/11/30 19:35
 */
//@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue() {
        return new Queue(QueueConstants.TEST);
    }
}
