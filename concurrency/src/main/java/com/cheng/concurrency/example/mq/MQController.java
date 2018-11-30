package com.cheng.concurrency.example.mq;

import com.cheng.concurrency.example.mq.kafaka.KafkaSender;
import com.cheng.concurrency.example.mq.rabbitmq.RabbitMQClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author cheng
 *         2018/11/30 19:34
 */
//@Controller
//@RequestMapping("/mq")
public class MQController {

    @Resource
    private RabbitMQClient rabbitMQClient;

    @Resource
    private KafkaSender kafkaSender;

    @RequestMapping("/send")
    @ResponseBody
    public String send(@RequestParam("message") String message) {
        rabbitMQClient.send(message);
        kafkaSender.send(message);
        return "success";
    }
}
