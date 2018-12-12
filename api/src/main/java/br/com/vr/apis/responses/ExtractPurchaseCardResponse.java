package br.com.vr.apis.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ExtractPurchaseCardResponse {

    private String purchaseCardId;
    private Integer days;

}