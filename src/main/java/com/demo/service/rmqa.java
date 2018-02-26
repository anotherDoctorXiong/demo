package com.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
@Component
public class rmqa {
    @Autowired
    private AmqpTemplate rabbitTemplate;
/*

    public void send() {
        */
/*rabbitTemplate.send(message);   //发消息，参数类型为org.springframework.amqp.core.Message
        rabbitTemplate.convertAndSend(object); //转换并发送消息。 将参数对象转换为org.springframework.amqp.core.Message后发送
        rabbitTemplate.convertSendAndReceive(message) //转换并发送消息,且等待消息者返回响应消息。*//*

        String context = "message";
        System.out.println("Sender : " + context);
        for(int i=0;i<10;i++){
            this.rabbitTemplate.convertAndSend("Exchange","key",context+i);
        }
    }
    @RabbitListener(queues = "queue1")
    public void processMessage1(String msg) {
        System.out.println( " 接收到来自queue1队列的消息：" + msg);
    }
*/

}
