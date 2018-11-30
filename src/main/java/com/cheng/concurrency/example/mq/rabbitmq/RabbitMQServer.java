package com.cheng.concurrency.example.mq.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author cheng
 *         2018/11/30 19:42
 */
@Slf4j
//@Component
public class RabbitMQServer {

    @RabbitListener(queues = QueueConstants.TEST)
    private void receive(String message) {
        log.info("{}", message);
    }
}
