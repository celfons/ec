package br.com.vr.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PurchaseCardException extends RuntimeException {
    public PurchaseCardException(String purchaseCardId) {
        super(purchaseCardId);
    }
}