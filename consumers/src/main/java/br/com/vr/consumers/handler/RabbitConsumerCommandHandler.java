package br.com.vr.consumers.handler;

import br.com.vr.domains.PurchaseCard;
import br.com.vr.domains.commands.UnlockPurchaseCardCommand;
import br.com.vr.domains.commands.handlers.PurchaseCardCommandHandler;
import br.com.vr.domains.repository.PurchaseCardRepository;
import br.com.vr.domains.services.KenanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumerCommandHandler {

    @Autowired
    PurchaseCardRepository repository;

    @Autowired
    KenanService kenanService;

    private static final Logger LOGGER = LogManager.getLogger(PurchaseCardCommandHandler.class.getName());

    public PurchaseCard handler(UnlockPurchaseCardCommand unlockPurchaseCardCommand) {
        final PurchaseCard purchaseCard;
        LOGGER.info("Unlock Purchase Card!");
        purchaseCard = repository.findById(unlockPurchaseCardCommand.getPurchaseCardId()).get();
        purchaseCard.unlockPurchaseCard(unlockPurchaseCardCommand, kenanService);
        repository.save(purchaseCard);
        LOGGER.info("Unlocked Purchase Card!");
        return purchaseCard;
    }

}
