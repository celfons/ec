package br.com.vr.domains.events;

import br.com.vr.domains.*;

import java.util.ArrayList;

public class CreatedPurchaseCardEvent implements PurchaseCardEvents {

    private PurchaseCardId purchaseCardId;
    private UnlockCard unlockCard;
    private Balance balance;
    private Cnpj cnpj;
    private PurchaseCardType purchaseCardType;
    private Category category;
    private CashBack cashBack;
    private Pat pat;
    private ArrayList<Transaction> transactions;

    public CreatedPurchaseCardEvent(
            PurchaseCardId purchaseCardId,
            UnlockCard unlockCard,
            Balance balance,
            Cnpj cnpj,
            PurchaseCardType purchaseCardType,
            Category category,
            CashBack cashBack,
            Pat pat,
            ArrayList<Transaction> transactions
    ) {
        this.purchaseCardId = purchaseCardId;
        this.unlockCard = unlockCard;
        this.balance = balance;
        this.cnpj = cnpj;
        this.purchaseCardType = purchaseCardType;
        this.category = category;
        this.cashBack = cashBack;
        this.pat = pat;
        this.transactions = transactions;
    }

    public PurchaseCardId getPurchaseCardId() {
        return purchaseCardId;
    }

    public void setPurchaseCardId(PurchaseCardId purchaseCardId) {
        this.purchaseCardId = purchaseCardId;
    }

    public UnlockCard getUnlockCard() {
        return unlockCard;
    }

    public void setUnlockCard(UnlockCard unlockCard) {
        this.unlockCard = unlockCard;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Cnpj getCnpj() {
        return cnpj;
    }

    public void setCnpj(Cnpj cnpj) {
        this.cnpj = cnpj;
    }

    public PurchaseCardType getPurchaseCardType() {
        return purchaseCardType;
    }

    public void setPurchaseCardType(PurchaseCardType purchaseCardType) {
        this.purchaseCardType = purchaseCardType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CashBack getCashBack() {
        return cashBack;
    }

    public void setCashBack(CashBack cashBack) {
        this.cashBack = cashBack;
    }

    public Pat getPat() {
        return pat;
    }

    public void setPat(Pat pat) {
        this.pat = pat;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
