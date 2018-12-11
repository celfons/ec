package br.com.vr.apis.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class CreatePurchaseCardResponse {

    private String cnpj;
    private String purchaseCardType;
    private String category;
    private Integer cashBack;
    private Boolean pat;

}
