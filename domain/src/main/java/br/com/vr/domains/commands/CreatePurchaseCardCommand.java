package br.com.vr.domains.commands;

public class CreatePurchaseCardCommand implements PurchaseCardCommands {

    private String cnpj;
    private String purchaseCardType;
    private String category;
    private Integer cashBack;
    private Boolean pat;

    public CreatePurchaseCardCommand(String cnpj, String purchaseCardType, String category, Integer cashBack, Boolean pat) {
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
