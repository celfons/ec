package br.com.vr.apis.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UnlockCardResponse {

    private String purchaseCardId;
    private Boolean unlockValue;

}
