package br.com.vr.controllers;

import br.com.vr.apis.PurchaseCardApi;
import br.com.vr.apis.requests.CreatePurchaseCardRequest;
import br.com.vr.apis.requests.UnlockCardRequest;
import br.com.vr.apis.responses.CreatePurchaseCardResponse;
import br.com.vr.apis.responses.UnlockCardResponse;
import br.com.vr.domains.PurchaseCard;
import br.com.vr.domains.commands.CreatePurchaseCardCommand;
import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.commands.handlers.PurchaseCardCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
class PurchaseCardController implements PurchaseCardApi {

    @Autowired
    private PurchaseCardCommandHandler purchaseCardCommandHandler;

    @Override
    public CreatePurchaseCardResponse createPurchaseCard(@Valid CreatePurchaseCardRequest createPurchaseCardRequest) {
        CreatePurchaseCardCommand createPurchaseCardCommand = CreatePurchaseCardCommand
                .builder()
                .cnpj(createPurchaseCardRequest.getCnpj())
                .purchaseCardType(createPurchaseCardRequest.getPurchaseCardType())
                .cashBack(createPurchaseCardRequest.getCashBack())
                .category(createPurchaseCardRequest.getCategory())
                .pat(createPurchaseCardRequest.getPat())
                .build();
        PurchaseCard purchaseCard = purchaseCardCommandHandler.handler(createPurchaseCardCommand);
        return CreatePurchaseCardResponse
                .builder()
                .cnpj(purchaseCard.getCnpj())
                .purchaseCardType(purchaseCard.getPurchaseCardType())
                .cashBack(purchaseCard.getCashBack())
                .category(purchaseCard.getCategory())
                .pat(purchaseCard.getPat())
                .build();
    }

    @Override
    public UnlockCardResponse unlockCard(@RequestBody @Valid UnlockCardRequest unlockCardRequest) throws Exception {
        UnlockCardCommand unlockCardCommand = UnlockCardCommand
                .builder()
                .purchaseCardId(unlockCardRequest.getPurchaseCardId())
                .unlockValue(unlockCardRequest.getUnlockValue())
                .build();
        PurchaseCard purchaseCard = purchaseCardCommandHandler.handler(unlockCardCommand);
        return UnlockCardResponse
                .builder()
                .purchaseCardId(purchaseCard.getPurchaseCardId())
                .unlockValue(purchaseCard.getUnlockCard())
                .build();
    }

}
