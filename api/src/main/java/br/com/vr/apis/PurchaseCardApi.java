package br.com.vr.apis;

import br.com.vr.apis.requests.UnlockCardRequest;
import br.com.vr.apis.responses.UnlockCardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

public interface PurchaseCardApi {

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(
            value = "/api",
            method = RequestMethod.POST
    )
    UnlockCardResponse unlockCard(@RequestBody @Valid UnlockCardRequest unlockCardRequest);

}
