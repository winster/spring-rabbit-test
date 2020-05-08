package com.example.springboot.rabbitmqdemo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventListener {

    @RabbitListener(id="bookingEventsReceiver", queues = "ccbd_queue")
    public void receive(String message) {
        log.info("receive :: {}", message);
    }

}
