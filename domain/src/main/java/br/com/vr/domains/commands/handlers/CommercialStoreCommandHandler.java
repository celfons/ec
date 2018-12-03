package br.com.vr.domains.commands.handlers;

import br.com.vr.domains.PurchaseCard;
import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.shared.CommandHandler;
import br.com.vr.repositories.DynamoRepository;
import br.com.vr.services.KenanService;
import br.com.vr.services.RabbitProducer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommercialStoreCommandHandler implements CommandHandler {

    @Autowired
    DynamoRepository repository;

    @Autowired
    KenanService kenanService;

    @Autowired
    RabbitProducer rabbitProducer;

    private static final Logger LOGGER = LogManager.getLogger(CommercialStoreCommandHandler.class.getName());

    public void handler(UnlockCardCommand unlockCardCommand){
        LOGGER.info("handler!!!");
        PurchaseCard purchaseCard = repository.findById(unlockCardCommand.getPurchaseCardId()).get();
        purchaseCard.unlockCard(unlockCardCommand, kenanService);
        repository.save(purchaseCard);
        LOGGER.info("unlockedCard!!!");
    }


}
