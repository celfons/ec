package br.com.vr.controllers;

import br.com.vr.apis.PurchaseCardApi;
import br.com.vr.apis.requests.CreatePurchaseCardRequest;
import br.com.vr.apis.requests.ExtractPurchaseCardRequest;
import br.com.vr.apis.requests.UnlockPurchaseCardRequest;
import br.com.vr.apis.responses.CreatePurchaseCardResponse;
import br.com.vr.apis.responses.ExtractPurchaseCardResponse;
import br.com.vr.apis.responses.UnlockCardResponse;
import br.com.vr.domains.PurchaseCard;
import br.com.vr.domains.commands.CreatePurchaseCardCommand;
import br.com.vr.domains.commands.ExtractPurchaseCardCommand;
import br.com.vr.domains.commands.UnlockPurchaseCardCommand;
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
        return new CreatePurchaseCardResponse(
                purchaseCard.getPurchaseCardId(),
                purchaseCard.getCnpj(),
                purchaseCard.getPurchaseCardType(),
                purchaseCard.getCategory(),
                purchaseCard.getCashBack(),
                purchaseCard.getPat()
        );
    }

    @Override
    public UnlockCardResponse unlockPurchaseCard(@RequestBody @Valid UnlockPurchaseCardRequest unlockPurchaseCardRequest) {
        UnlockPurchaseCardCommand unlockPurchaseCardCommand = UnlockPurchaseCardCommand
                .builder()
                .purchaseCardId(unlockPurchaseCardRequest.getPurchaseCardId())
                .unlockValue(unlockPurchaseCardRequest.getUnlockValue())
                .build();
        PurchaseCard purchaseCard = purchaseCardCommandHandler.handler(unlockPurchaseCardCommand);
        return new UnlockCardResponse(purchaseCard.getPurchaseCardId(), purchaseCard.getUnlockCard());
    }

    @Override
    public ExtractPurchaseCardResponse extractPurchaseCard(@Valid ExtractPurchaseCardRequest extractPurchaseCardRequest) {
        ExtractPurchaseCardCommand extractPurchaseCardCommand = ExtractPurchaseCardCommand
                .builder()
                .purchaseCardId(extractPurchaseCardRequest.getPurchaseCardId())
                .days(extractPurchaseCardRequest.getDays())
                .build();
        purchaseCardCommandHandler.handler(extractPurchaseCardCommand);
        return new ExtractPurchaseCardResponse(extractPurchaseCardRequest.getPurchaseCardId(), extractPurchaseCardRequest.getDays());
    }

}
