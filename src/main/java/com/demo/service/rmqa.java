package com.demo.service;

import com.demo.model.Adminer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class  rmqa {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;
    @Autowired
    private MappingJackson2MessageConverter mappingJackson2MessageConverter;
/*

    public void send() {
        Adminer user=new Adminer();
        user.setName("daf");
        this.rabbitMessagingTemplate.setMessageConverter(this.mappingJackson2MessageConverter);
        System.out.println("Sender : " + user.toString());
        this.rabbitMessagingTemplate.convertAndSend("Exchange","key",user);
    }


    @RabbitListener(queues = "queue1")
    public void process(Adminer adminer) {
        System.out.println("Receiver  : " + adminer);
    }
*/


}
