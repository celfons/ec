package br.com.vr.domains.events;


import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnlockedCardEvent extends PurchaseCardEvents {

    private String purchaseCardId;
    private Boolean unlockCard;

}
