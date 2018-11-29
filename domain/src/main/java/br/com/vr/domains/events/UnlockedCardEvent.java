package br.com.vr.domains.events;

import br.com.vr.domains.Card;
import br.com.vr.domains.CommercialStoreId;

public class UnlockedCardEvent implements CommercialStoreEvents {

    private CommercialStoreId commercialStoreId;
    private Card card;

    public UnlockedCardEvent(CommercialStoreId commercialStoreId){
        this.commercialStoreId = commercialStoreId;
        this.card.setUnlocked(true);
    }
}
