package br.com.vr.domains.commands.handlers;

import br.com.vr.domains.*;
import br.com.vr.domains.commands.CreatePurchaseCardCommand;
import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.repository.PurchaseCardRepository;
import br.com.vr.domains.services.KenanService;
import br.com.vr.domains.shared.CommandHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PurchaseCardCommandHandler implements CommandHandler {

    @Autowired
    PurchaseCardRepository repository;

    @Autowired
    KenanService kenanService;

    private static final Logger LOGGER = LogManager.getLogger(PurchaseCardCommandHandler.class.getName());

    public PurchaseCard handler(CreatePurchaseCardCommand createPurchaseCardCommand) {
        LOGGER.info("Create Purchase Card!");
        PurchaseCard purchaseCard = PurchaseCard
                .builder()
                .purchaseCardType(createPurchaseCardCommand.getPurchaseCardType())
                .cashBack(createPurchaseCardCommand.getCashBack())
                .category(createPurchaseCardCommand.getCategory())
                .cnpj(createPurchaseCardCommand.getCnpj())
                .pat(createPurchaseCardCommand.getPat())
                .unlockCard(true)
                .balance(0.0)
                .transactions(new ArrayList<>())
                .build();
        purchaseCard.createPurchaseCard();
        repository.save(purchaseCard);
        LOGGER.info("Created Purchase Card!");
        return purchaseCard;
    }

    public PurchaseCard handler(UnlockCardCommand unlockCardCommand) {
        final PurchaseCard purchaseCard;
        LOGGER.info("Unlock Purchase Card!");
        purchaseCard = repository.findById(unlockCardCommand.getPurchaseCardId()).get();
        purchaseCard.unlockCard(unlockCardCommand, kenanService);
        repository.save(purchaseCard);
        LOGGER.info("Unlocked Purchase Card!");
        return purchaseCard;
    }

}
