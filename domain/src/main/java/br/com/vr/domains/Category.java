package br.com.vr.domains;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public enum Category {
    FOOD("FOOD"),
    MEAL("MEAL"),
    AUTO("AUTO"),
    CULTURE("CULTURE");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
