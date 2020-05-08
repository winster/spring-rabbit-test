package com.example.springboot.rabbitmqdemo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix = "rabbitmq")
@Validated
@Getter
@Setter
public class MyConfigParameters {
    private String receiver1ListenerId;
    private String receiver1ExchangeName;
    private String receiver1QueueName;
    private String receiver1RoutingKey;

    private String receiver2ListenerId;
    private String receiver2ExchangeName;
    private String receiver2QueueName;
    private String receiver2RoutingKey;
}
