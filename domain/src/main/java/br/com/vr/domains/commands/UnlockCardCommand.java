package br.com.vr.domains.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class UnlockCardCommand implements PurchaseCardCommands {

    private String purchaseCardId;
    private Boolean unlockValue;

}
