package br.com.vr.domains.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ExtractPurchaseCardCommand implements PurchaseCardCommands {

    private String purchaseCardId;
    private Integer days;

}
