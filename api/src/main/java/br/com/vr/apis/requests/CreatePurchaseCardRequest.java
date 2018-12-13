package br.com.vr.apis.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePurchaseCardRequest {

    @JsonProperty("cnpj") private String cnpj;
    @JsonProperty("purchaseCardType") private String purchaseCardType;
    @JsonProperty("category") private String category;
    @JsonProperty("cashBack") private Integer cashBack;
    @JsonProperty("pat") private Boolean pat;

}
