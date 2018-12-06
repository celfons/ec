package br.com.vr.domains;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public enum PurchaseCardType {

    PRODUCT("PRODUCT"),
    SUBPRODUCT("SUBPRODUCT");

    private String value;

    PurchaseCardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
