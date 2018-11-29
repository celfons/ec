package br.com.vr.controllers;

import br.com.vr.apis.CommercialStoreApi;
import br.com.vr.domains.CommercialStoreId;
import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.commands.handlers.CommercialStoreCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CommercialStoreController implements CommercialStoreApi {

    @Autowired
    private CommercialStoreCommandHandler commercialStoreCommandHandler;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(
            value = "/api",
            method = RequestMethod.POST
    )
    public void unlockCard(@RequestBody @Valid String request) {
        CommercialStoreId commercialStoreId = new CommercialStoreId(request);
        UnlockCardCommand unlockCardCommand = new UnlockCardCommand(commercialStoreId);
        commercialStoreCommandHandler.handler(unlockCardCommand);
    }
}
