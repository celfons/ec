package br.com.vr.controllers;

import br.com.vr.apis.requests.CreatePurchaseCardRequest;
import br.com.vr.apis.responses.CreatePurchaseCardResponse;
import br.com.vr.apis.PurchaseCardApi;
import br.com.vr.apis.requests.UnlockCardRequest;
import br.com.vr.apis.responses.UnlockCardResponse;
import br.com.vr.controllers.builders.PurchaseCardBuilder;
import br.com.vr.domains.PurchaseCard;
import br.com.vr.domains.commands.CreatePurchaseCardCommand;
import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.commands.handlers.PurchaseCardCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
class PurchaseCardController implements PurchaseCardApi {

    @Autowired
    private PurchaseCardCommandHandler purchaseCardCommandHandler;

    @Autowired
    private PurchaseCardBuilder purchaseCardBuilder;

    @Override
    public CreatePurchaseCardResponse createPurchaseCard(@Valid CreatePurchaseCardRequest createPurchaseCardRequest) {
        CreatePurchaseCardCommand createPurchaseCardCommand = purchaseCardBuilder.createPurchaseCardBuilder(createPurchaseCardRequest);
        PurchaseCard purchaseCard = purchaseCardCommandHandler.handler(createPurchaseCardCommand);
        return purchaseCardBuilder.createPurchaseCardResponseBuilder(purchaseCard);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(
            value = "/api",
            method = RequestMethod.POST
    )
    public UnlockCardResponse unlockCard(@RequestBody @Valid UnlockCardRequest unlockCardRequest) {
        UnlockCardCommand unlockCardCommand = purchaseCardBuilder.unlockCardCommandBuilder(unlockCardRequest);
        PurchaseCard purchaseCard = purchaseCardCommandHandler.handler(unlockCardCommand);
        return purchaseCardBuilder.unlockCardResponseBuilder(purchaseCard);
    }

}
