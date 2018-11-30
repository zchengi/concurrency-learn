package com.cheng.concurrency.example.mq.kafaka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author cheng
 *         2018/11/30 19:33
 */
//@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {TopicConstants.TEST})
    public void receive(ConsumerRecord<?, ?> record) {
        log.info("record: {}", record);
    }
}
