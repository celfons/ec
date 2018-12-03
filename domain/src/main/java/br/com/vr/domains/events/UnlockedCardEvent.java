package br.com.vr.domains.events;

import br.com.vr.domains.PurchaseCardId;
import br.com.vr.domains.UnlockCard;

public class UnlockedCardEvent implements CommercialStoreEvents {

    private PurchaseCardId purchaseCardId;
    private UnlockCard unlockCard;

    public UnlockedCardEvent(PurchaseCardId purchaseCardId, UnlockCard unlockCard){
        this.purchaseCardId = purchaseCardId;
        this.unlockCard = unlockCard;
    }
}
