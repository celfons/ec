package br.com.vr.consumers;

import br.com.vr.domains.commands.UnlockPurchaseCardCommand;
import br.com.vr.domains.commands.handlers.PurchaseCardCommandHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {

    @Autowired
    private PurchaseCardCommandHandler purchaseCardCommandHandler;

    @RabbitListener(queues = {"${queue.order.name}"})
    public void receive(@Payload String purchaseCardId) {
        UnlockPurchaseCardCommand unlockPurchaseCardCommand = UnlockPurchaseCardCommand
                .builder()
                .purchaseCardId(purchaseCardId)
                .unlockValue(false)
                .build();
        purchaseCardCommandHandler.handler(unlockPurchaseCardCommand);
    }
}