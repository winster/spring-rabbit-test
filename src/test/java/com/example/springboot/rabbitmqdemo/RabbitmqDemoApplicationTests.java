package com.example.springboot.rabbitmqdemo;

import com.example.springboot.rabbitmqdemo.config.RabbitTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ActiveProfiles("test")
class RabbitmqDemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
