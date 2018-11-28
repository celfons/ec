package br.com.vr.domains;

import br.com.vr.domains.shared.RandomUUID;

public class CommercialStoreId extends RandomUUID {

    public CommercialStoreId() {
        super();
    }

    public CommercialStoreId(String id) {
        super(id);
    }

    @Override
    protected String getPrefix() {
        return null;
    }
}
