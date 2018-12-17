package br.com.vr.domains.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class IncreasePurchaseCardCommand implements PurchaseCardCommands {

    private String purchaseCardId;
    private Double value;

}