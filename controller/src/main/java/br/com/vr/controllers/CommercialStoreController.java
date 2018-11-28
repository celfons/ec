package br.com.vr.controllers;

import br.com.vr.apis.CommercialStoreApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CommercialStoreController implements CommercialStoreApi {

    @Override
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(
            value = "/api",
            method = RequestMethod.POST
    )
    public void unlockCard(@RequestBody @Valid String request) {
        //TODO implements
    }
}
