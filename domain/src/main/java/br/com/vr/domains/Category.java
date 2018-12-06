package br.com.vr.domains;

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
