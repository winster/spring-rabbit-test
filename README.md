# Spring RabbitMQ Test Sample Application 
This application was created as a reference for an issue [1195](https://github.com/spring-projects/spring-amqp/issues/1195) 
about using expression language in **RabbitListener** annotation. But as guided by
by community expert, it works as expected as given in 
[documentation](https://docs.spring.io/spring-amqp/docs/2.2.6.RELEASE/reference/html/#test-template).
So consider this application as an example for using spring-rabbit-test library.  

#### TestRabbitTemplate

Integration test using **TestRabbitTemplate**

1. ListenerIT <br/>
    Test if listeners mapping is correct (currently message can be sent by using Queue name)

###
Application configuration. RabbitMQ should be running.

It uses default host. Also spring-amqp auto declare exchange, queue and binding. 
Hence the application will just work out of the box.

1. Publish message to **exchange**:*exchange1* & **routing-key**:*one*
2. Publish message to **exchange**:*exchange2* & **routing-key**:*two*
