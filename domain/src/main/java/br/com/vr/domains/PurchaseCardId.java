package br.com.vr.domains;

import br.com.vr.domains.shared.RandomUUID;

public class PurchaseCardId extends RandomUUID {

    public PurchaseCardId() {
        super();
    }

    public PurchaseCardId(String id) {
        super(id);
    }

    @Override
    protected String getPrefix() {
        return null;
    }
}
