package br.com.vr.apis;

import br.com.vr.apis.requests.CreatePurchaseCardRequest;
import br.com.vr.apis.requests.UnlockCardRequest;
import br.com.vr.apis.responses.CreatePurchaseCardResponse;
import br.com.vr.apis.responses.UnlockCardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

public interface PurchaseCardApi {

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @RequestMapping(
            value = "/purchase-card",
            method = RequestMethod.POST
    )
    CreatePurchaseCardResponse createPurchaseCard(@RequestBody @Valid CreatePurchaseCardRequest createPurchaseCardRequest);

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(
            value = "/unlock",
            method = RequestMethod.POST
    )
    UnlockCardResponse unlockCard(@RequestBody @Valid UnlockCardRequest unlockCardRequest);

}
