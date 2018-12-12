package br.com.vr.apis.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExtractPurchaseCardRequest {

    @JsonProperty("purchaseCardId") private String purchaseCardId;

    @JsonProperty("days") private Integer days;

}
