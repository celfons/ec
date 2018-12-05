package br.com.vr.domains.commands;

import br.com.vr.domains.PurchaseCardId;
import br.com.vr.domains.UnlockCard;

public class UnlockCardCommand implements PurchaseCardCommands {

    private PurchaseCardId purchaseCardId;
    private UnlockCard unlockValue;

    public UnlockCardCommand(PurchaseCardId purchaseCardId, UnlockCard unlockValue) {
        this.purchaseCardId = purchaseCardId;
        this.unlockValue = unlockValue;
    }

    public PurchaseCardId getPurchaseCardId() {
        return purchaseCardId;
    }

    public void setPurchaseCardId(PurchaseCardId purchaseCardId) {
        this.purchaseCardId = purchaseCardId;
    }

    public UnlockCard getUnlockValue() {
        return unlockValue;
    }

    public void setUnlockValue(UnlockCard unlockValue) {
        this.unlockValue = unlockValue;
    }
}
