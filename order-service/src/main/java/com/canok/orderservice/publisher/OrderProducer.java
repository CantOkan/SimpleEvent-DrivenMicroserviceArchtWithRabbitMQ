package com.canok.orderservice.publisher;

import com.canok.orderservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private final static Logger LOGGER=LoggerFactory.getLogger(OrderProducer.class);

    @Value("${rabbitmq.queue.order.exchange}")
    private String exchange;

    @Value("${rabbitmq.queue.order.routingKey}")
    private String routingKey;


    @Value("${rabbitmq.queue.eamil.routingKey}")
    private String emailRoutingKey;

    private RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(OrderEvent orderEvent){
        LOGGER.info(String.format("Order Event sent to RabbitMQ -> %s",orderEvent.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKey,orderEvent);

        rabbitTemplate.convertAndSend(exchange,emailRoutingKey,orderEvent);
    }
}
