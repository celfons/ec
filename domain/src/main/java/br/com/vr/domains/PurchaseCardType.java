package br.com.vr.domains;

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
