package com.example.springboot.rabbitmqdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    private final MyConfigParameters myConfigParameters;

    public RabbitMQConfiguration(MyConfigParameters myConfigParameters) {
        this.myConfigParameters = myConfigParameters;
    }

    @Bean
    public DirectExchange receiver1Exchange() {
        return ExchangeBuilder.directExchange(myConfigParameters.getReceiver1ExchangeName())
                .ignoreDeclarationExceptions().build();
    }

    @Bean
    public Queue receiver1Queue() {
        return QueueBuilder.durable(myConfigParameters.getReceiver1QueueName())
                .build();
    }

    @Bean
    public Binding receiver1Binding() {
        return BindingBuilder.bind(receiver1Queue())
                .to(receiver1Exchange())
                .with(myConfigParameters.getReceiver1RoutingKey());
    }
    @Bean
    public DirectExchange receiver2Exchange() {
        return ExchangeBuilder.directExchange(myConfigParameters.getReceiver2ExchangeName())
                .ignoreDeclarationExceptions().build();
    }

    @Bean
    public Queue receiver2Queue() {
        return QueueBuilder.durable(myConfigParameters.getReceiver2QueueName())
                .build();
    }

    @Bean
    public Binding receiver2Binding() {
        return BindingBuilder.bind(receiver2Queue())
                .to(receiver2Exchange())
                .with(myConfigParameters.getReceiver2RoutingKey());
    }

    /**
     * In case connection to RabbitMQ throws ACCESS_REFUSED as user not created/permitted yet there
     * @param configurer
     * @param connectionFactory
     * @return
     */
    @Bean(name = "rabbitListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setContainerCustomizer(smlc -> smlc.setPossibleAuthenticationFailureFatal(false));
        return factory;
    }

}
