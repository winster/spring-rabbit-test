package com.example.springboot.rabbitmqdemo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener2 {

    @RabbitListener(id="${rabbitmq.receiver2ListenerId}", queues = "${rabbitmq.receiver2QueueName}")
    public void receive(String message) {
        log.info("Listener2: receive :: {}", message);
    }

}
