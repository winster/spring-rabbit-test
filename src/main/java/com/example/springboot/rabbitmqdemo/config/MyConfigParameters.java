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
    private String myListenerId;
    private String myExchangeName;
    private String myQueueName;
    private String myRoutingKey;
}
