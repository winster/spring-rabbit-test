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
    public DirectExchange myExchange() {
        return ExchangeBuilder.directExchange(myConfigParameters.getMyExchangeName())
                .ignoreDeclarationExceptions().build();
    }

    @Bean
    public Queue myQueue() {
        return QueueBuilder.durable(myConfigParameters.getMyQueueName())
                .build();
    }

    @Bean
    public Binding myBinding() {
        return BindingBuilder.bind(myQueue())
                .to(myExchange())
                .with(myConfigParameters.getMyRoutingKey());
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
