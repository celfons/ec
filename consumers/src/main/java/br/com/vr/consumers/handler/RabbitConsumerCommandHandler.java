package br.com.vr.consumers.handler;

import br.com.vr.domains.PurchaseCard;
import br.com.vr.domains.commands.IncreasePurchaseCardCommand;
import br.com.vr.domains.commands.handlers.PurchaseCardCommandHandler;
import br.com.vr.domains.services.KenanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RabbitConsumerCommandHandler {

    @Autowired
    CrudRepository<PurchaseCard, String> repository;

    @Autowired
    KenanService kenanService;

    private static final Logger LOGGER = LogManager.getLogger(PurchaseCardCommandHandler.class.getName());

    @Transactional
    public PurchaseCard handler(IncreasePurchaseCardCommand increasePurchaseCardCommand) {
        final PurchaseCard purchaseCard;
        LOGGER.info("Increase Purchase Card!");
        purchaseCard = repository.findById(increasePurchaseCardCommand.getPurchaseCardId()).get();
        purchaseCard.increasePurchaseCard(increasePurchaseCardCommand);
        repository.save(purchaseCard);
        LOGGER.info("Increased Purchase Card!");
        return purchaseCard;
    }

}
