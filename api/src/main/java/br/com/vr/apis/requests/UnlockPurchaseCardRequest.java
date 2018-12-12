package br.com.vr.apis.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UnlockPurchaseCardRequest {

    @JsonProperty("purchaseCardId") private String purchaseCardId;

    @JsonProperty("unlockValue") private Boolean unlockValue;

}
