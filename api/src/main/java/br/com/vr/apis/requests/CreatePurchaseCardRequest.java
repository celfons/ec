package br.com.vr.apis.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatePurchaseCardRequest {

    @JsonProperty("cnpj") private String cnpj;
    @JsonProperty("purchaseCardType") private String purchaseCardType;
    @JsonProperty("category") private String category;
    @JsonProperty("cashBack") private Integer cashBack;
    @JsonProperty("pat") private Boolean pat;

    public CreatePurchaseCardRequest(String cnpj, String purchaseCardType, String category, Integer cashBack, Boolean pat) {
        this.cnpj = cnpj;
        this.purchaseCardType = purchaseCardType;
        this.category = category;
        this.cashBack = cashBack;
        this.pat = pat;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPurchaseCardType() {
        return purchaseCardType;
    }

    public void setPurchaseCardType(String purchaseCardType) {
        this.purchaseCardType = purchaseCardType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCashBack() {
        return cashBack;
    }

    public void setCashBack(Integer cashBack) {
        this.cashBack = cashBack;
    }

    public Boolean getPat() {
        return pat;
    }

    public void setPat(Boolean pat) {
        this.pat = pat;
    }
}
