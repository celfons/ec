package br.com.vr.producers;

import br.com.vr.domains.services.RabbitProducerService;
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

    public void send(String purchaseCardId) {
        rabbitTemplate.convertAndSend(this.queue.getName(), purchaseCardId);
    }
}
