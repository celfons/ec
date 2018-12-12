package br.com.vr.producers.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitProducerApplication {

    @Value("${queue.order.name}")
    private String orderQueue;

    private static final Logger LOGGER = LogManager.getLogger(RabbitProducerApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class, args);
        LOGGER.info("Debug Message Logged !!!");
    }

    @Bean
    public Queue queue() {
        return new Queue(orderQueue, true);
    }

}