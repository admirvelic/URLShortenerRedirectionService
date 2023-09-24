package com.vella.URLShortenerRedirectionService.config;


import com.vella.URLShortenerRedirectionService.service.ReceiverService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sound.midi.Receiver;

@Configuration
public class RabbitConfig {

    @Value("${rabbitmq.queue}")
    String queueName;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(ReceiverService receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
