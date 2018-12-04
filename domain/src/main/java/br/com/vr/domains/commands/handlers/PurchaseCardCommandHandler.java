package br.com.vr.domains.commands.handlers;

import br.com.vr.domains.PurchaseCard;
import br.com.vr.domains.PurchaseCardId;
import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.services.KenanService;
import br.com.vr.domains.services.RabbitProducer;
import br.com.vr.domains.shared.CommandHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.data.repository.CrudRepository;

@Component
public class PurchaseCardCommandHandler implements CommandHandler {

    @Autowired
    CrudRepository<PurchaseCard, PurchaseCardId> repository;

    @Autowired
    KenanService kenanService;

    @Autowired
    RabbitProducer rabbitProducer;

    private static final Logger LOGGER = LogManager.getLogger(PurchaseCardCommandHandler.class.getName());

    public void handler(UnlockCardCommand unlockCardCommand){
        LOGGER.info("handler!!!");
        PurchaseCard purchaseCard = repository.findById(unlockCardCommand.getPurchaseCardId()).get();
        purchaseCard.unlockCard(unlockCardCommand, kenanService);
        repository.save(purchaseCard);
        LOGGER.info("unlockedCard!!!");
    }


}
