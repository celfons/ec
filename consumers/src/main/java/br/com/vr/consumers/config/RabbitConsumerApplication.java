package br.com.vr.consumers.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableRabbit
@ComponentScan({"br.com.vr.consumers", "br.com.vr.repositories", "br.com.vr.integrations"})
public class RabbitConsumerApplication {

    @Value("${queue.order.name}")
    private String orderQueue;

    private static final Logger LOGGER = LogManager.getLogger(RabbitConsumerApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumerApplication.class, args);
        LOGGER.info("Debug Message Logged !!!");
    }
    @Bean
    public Queue queue() {
        return new Queue(orderQueue, true);
    }

}