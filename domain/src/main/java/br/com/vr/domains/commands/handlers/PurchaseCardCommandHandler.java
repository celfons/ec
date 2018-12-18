package br.com.vr.domains.commands.handlers;

import br.com.vr.domains.PurchaseCard;
import br.com.vr.domains.commands.CreatePurchaseCardCommand;
import br.com.vr.domains.commands.ExtractPurchaseCardCommand;
import br.com.vr.domains.commands.UnlockPurchaseCardCommand;
import br.com.vr.domains.repository.PurchaseCardRepository;
import br.com.vr.domains.services.KenanService;
import br.com.vr.domains.services.RabbitProducerService;
import br.com.vr.domains.shared.CommandHandler;
import br.com.vr.infra.exception.PurchaseCardException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Component
public class PurchaseCardCommandHandler implements CommandHandler {

    @Autowired
    PurchaseCardRepository repository;

    @Autowired
    KenanService kenanService;

    @Autowired
    RabbitProducerService rabbitProducerService;

    private static final Logger LOGGER = LogManager.getLogger(PurchaseCardCommandHandler.class.getName());

    @Transactional
    public PurchaseCard handler(CreatePurchaseCardCommand createPurchaseCardCommand) {
        final PurchaseCard purchaseCard;
        LOGGER.info("Create Purchase Card!");
        purchaseCard = PurchaseCard
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
        rabbitProducerService.send(purchaseCard.getPurchaseCardId());
        LOGGER.info("Created Purchase Card!");
        return purchaseCard;
    }

    @Transactional
    public PurchaseCard handler(UnlockPurchaseCardCommand unlockPurchaseCardCommand) {
        final PurchaseCard purchaseCard;
        LOGGER.info("Unlock Purchase Card!");
        purchaseCard = repository.findById(unlockPurchaseCardCommand.getPurchaseCardId()).orElseThrow(()
               ->  new PurchaseCardException(unlockPurchaseCardCommand.getPurchaseCardId())
        );
        purchaseCard.unlockPurchaseCard(unlockPurchaseCardCommand, kenanService);
        repository.save(purchaseCard);
        LOGGER.info("Unlocked Purchase Card!");
        return purchaseCard;
    }

    public PurchaseCard handler(ExtractPurchaseCardCommand extractPurchaseCardCommand) {
        final PurchaseCard purchaseCard;
        LOGGER.info("Extract Purchase Card!");
        purchaseCard = repository.findById(extractPurchaseCardCommand.getPurchaseCardId()).orElseThrow(()
                ->  new PurchaseCardException(extractPurchaseCardCommand.getPurchaseCardId())
        );
        purchaseCard.extractPurchaseCard(extractPurchaseCardCommand, kenanService);
        LOGGER.info("Extract Purchase Card!");
        return purchaseCard;
    }
}
