package com.cheng.concurrency.example.mq.kafaka;

import com.cheng.concurrency.example.mq.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author cheng
 *         2018/11/30 19:24
 */
@Slf4j
public class KafkaSender {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send(String msg) {

        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMessage(msg);
        message.setSendTime(new Date());

        log.info("send message: {}", message);

        kafkaTemplate.send(TopicConstants.TEST, gson.toJson(message));
    }
}
