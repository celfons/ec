package br.com.vr.domains.commands;

import br.com.vr.domains.CommercialStoreId;

public class UnlockCardCommand implements CommercialStoreCommands {

    private CommercialStoreId commercialStoreId;

    public UnlockCardCommand(CommercialStoreId commercialStoreId) {
        this.commercialStoreId = commercialStoreId;
    }

    public CommercialStoreId getCommercialStoreId() {
        return commercialStoreId;
    }

    public void setCommercialStoreId(CommercialStoreId commercialStoreId) {
        this.commercialStoreId = commercialStoreId;
    }
}
