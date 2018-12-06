package br.com.vr.domains;

import br.com.vr.domains.shared.RandomUUID;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class PurchaseCardId extends RandomUUID {

    public PurchaseCardId() {
        super();
    }

    public PurchaseCardId(Long id) {
        super(id);
    }

}
