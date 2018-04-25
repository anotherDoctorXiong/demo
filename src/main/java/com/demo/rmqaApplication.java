package com.demo;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class rmqaApplication {
    //声明队列
    @Bean
    public Queue queue1() {
        return new Queue("queue1"); // true表示持久化该队列
    }

    @Bean
    public Queue queue2() {
        return new Queue("queue2");
    }

    //声明交互器
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("Exchange");
    }

    //绑定
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("key");
    }


}