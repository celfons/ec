package br.com.vr.consumers;

import br.com.vr.consumers.handler.RabbitConsumerCommandHandler;
import br.com.vr.domains.commands.UnlockPurchaseCardCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {

    @Autowired
    private RabbitConsumerCommandHandler rabbitConsumerCommandHandler;

    private static final Logger LOGGER = LogManager.getLogger(RabbitConsumer.class.getName());

    @RabbitListener(queues = {"${queue.order.name}"})
    public void receive(@Payload String purchaseCardId) {
        LOGGER.info("Consumed message");
        UnlockPurchaseCardCommand unlockPurchaseCardCommand = UnlockPurchaseCardCommand
                .builder()
                .purchaseCardId(purchaseCardId)
                .unlockValue(false)
                .build();
        rabbitConsumerCommandHandler.handler(unlockPurchaseCardCommand);
    }
}