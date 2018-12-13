package br.com.vr.producers;

import br.com.vr.domains.services.RabbitProducerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer implements RabbitProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    private static final Logger LOGGER = LogManager.getLogger(RabbitProducer.class.getName());

    public void send(String purchaseCardId) {
        rabbitTemplate.convertAndSend(this.queue.getName(), purchaseCardId);
        LOGGER.info("Published message");
    }
}
