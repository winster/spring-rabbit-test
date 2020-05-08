package com.example.springboot.rabbitmqdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RabbitmqDemoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RabbitmqDemoApplication.class)
                .profiles("dev")
                .run(args);
    }

}
