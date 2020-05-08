package com.example.springboot.rabbitmqdemo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener1 {

    @RabbitListener(id="receiver1", queues = "queue1")
    public void receive(String message) {
        log.info("Listener1: receive :: {}", message);
    }

}
