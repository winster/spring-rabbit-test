package com.example.springboot.rabbitmqdemo.listener;

import com.example.springboot.rabbitmqdemo.config.MyConfigParameters;
import com.example.springboot.rabbitmqdemo.config.RabbitTestConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.test.RabbitListenerTestHarness;
import org.springframework.amqp.rabbit.test.TestRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
@ContextConfiguration(classes = RabbitTestConfiguration.class)
public class ListenerIT {

    private Listener1 listener1;

    @Autowired
    private RabbitListenerTestHarness harness;

    @Autowired
    private TestRabbitTemplate testRabbitTemplate;

    @Autowired
    private MyConfigParameters myConfigParameters;

    @Test
    public void receiver1() {
        listener1 = harness.getSpy(myConfigParameters.getReceiver1ListenerId());
        assertNotNull(listener1);
        String message = getMessage();
        testRabbitTemplate.convertAndSend(myConfigParameters.getReceiver1QueueName(), message);
        verify(listener1).receive(message);
    }

    @SneakyThrows
    private String getMessage() {
        Map<String, String> bean = new HashMap<>();
        bean.put("key1","value1");
        bean.put("key2","value2");
        return new ObjectMapper().writeValueAsString(bean);
    }
}
