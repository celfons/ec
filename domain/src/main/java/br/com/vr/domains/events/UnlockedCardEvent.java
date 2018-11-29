package br.com.vr.domains.events;

import br.com.vr.domains.CommercialStoreId;

public class UnlockedCardEvent implements CommercialStoreEvents {

    private CommercialStoreId commercialStoreId;

    public UnlockedCardEvent(CommercialStoreId commercialStoreId){
        this.commercialStoreId = commercialStoreId;
    }
}
