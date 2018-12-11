package br.com.vr.domains.events;


import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class UnlockedCardEvent implements PurchaseCardEvents {

    private String purchaseCardId;
    private Boolean unlockCard;

}
