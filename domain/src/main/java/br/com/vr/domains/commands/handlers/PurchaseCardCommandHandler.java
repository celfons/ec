package br.com.vr.domains.commands.handlers;

import br.com.vr.domains.*;
import br.com.vr.domains.commands.CreatePurchaseCardCommand;
import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.services.KenanService;
import br.com.vr.domains.shared.CommandHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
@EnableScan
public class PurchaseCardCommandHandler implements CommandHandler {

    @Autowired
    CrudRepository<PurchaseCard, PurchaseCardId> repository;

    @Autowired
    KenanService kenanService;

    private static final Logger LOGGER = LogManager.getLogger(PurchaseCardCommandHandler.class.getName());

    public PurchaseCard handler(CreatePurchaseCardCommand createPurchaseCardCommand) {
        LOGGER.info("Create Purchase Card!");
        PurchaseCard purchaseCard = new PurchaseCard(
                new PurchaseCardId(),
                new UnlockCard(true),
                new Balance(0.0),
                new Cnpj(createPurchaseCardCommand.getCnpj()),
                PurchaseCardType.valueOf(PurchaseCardType.class, createPurchaseCardCommand.getPurchaseCardType()),
                Category.valueOf(Category.class, createPurchaseCardCommand.getCategory()),
                new CashBack(createPurchaseCardCommand.getCashBack()),
                new Pat(createPurchaseCardCommand.getPat()),
                null
        );
        purchaseCard.createPurchaseCard();
        repository.save(purchaseCard);
        LOGGER.info("Created Purchase Card!");
        return purchaseCard;
    }

    public PurchaseCard handler(UnlockCardCommand unlockCardCommand){
        LOGGER.info("Unlock Purchase Card!");
        PurchaseCard purchaseCard = repository.findById(unlockCardCommand.getPurchaseCardId()).get();
        purchaseCard.unlockCard(unlockCardCommand, kenanService);
        repository.save(purchaseCard);
        LOGGER.info("Unlocked Purchase Card!");
        return purchaseCard;
    }

}
