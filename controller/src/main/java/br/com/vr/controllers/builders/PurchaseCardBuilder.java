package br.com.vr.controllers.builders;

import br.com.vr.apis.requests.CreatePurchaseCardRequest;
import br.com.vr.apis.requests.UnlockCardRequest;
import br.com.vr.apis.responses.CreatePurchaseCardResponse;
import br.com.vr.apis.responses.UnlockCardResponse;
import br.com.vr.domains.*;
import br.com.vr.domains.commands.CreatePurchaseCardCommand;
import br.com.vr.domains.commands.UnlockCardCommand;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class PurchaseCardBuilder {

    public CreatePurchaseCardCommand createPurchaseCardBuilder(CreatePurchaseCardRequest createPurchaseCardRequest){
        return new CreatePurchaseCardCommand(
                createPurchaseCardRequest.getCnpj(),
                createPurchaseCardRequest.getPurchaseCardType(),
                createPurchaseCardRequest.getCategory(),
                createPurchaseCardRequest.getCashBack(),
                createPurchaseCardRequest.getPat()
        );
    }

    public CreatePurchaseCardResponse createPurchaseCardResponseBuilder(@Valid PurchaseCard purchaseCard) {
        return new CreatePurchaseCardResponse(
                purchaseCard.getCnpj().getValue(),
                purchaseCard.getPurchaseCardType().name(),
                purchaseCard.getCategory().name(),
                purchaseCard.getCashBack().getValue(),
                purchaseCard.getPat().getValue()
        );
    }

    public UnlockCardCommand unlockCardCommandBuilder(UnlockCardRequest unlockCardRequest){
        return new UnlockCardCommand(
                new PurchaseCardId(unlockCardRequest.getCardId()),
                new UnlockCard(unlockCardRequest.getValue())
        );
    }

    public UnlockCardResponse unlockCardResponseBuilder(PurchaseCard purchaseCard) {
        return new UnlockCardResponse(
                purchaseCard.getUnlockCard().getValue(),
                purchaseCard.getPurchaseCardId().id
        );
    }


}
