package br.com.vr.apis;

import br.com.vr.apis.requests.UnlockCardRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

public interface CommercialStoreApi {

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(
            value = "/api",
            method = RequestMethod.POST
    )
    void unlockCard(@RequestBody @Valid UnlockCardRequest unlockCardRequest);

}
