package br.com.vr.apis.requests;

public class UnlockCardRequest {

    private String cardId;
    private Boolean unlockValue;

    public UnlockCardRequest(Boolean value, String cardId) {
        this.unlockValue = value;
        this.cardId = cardId;
    }

    public Boolean getValue() {
        return unlockValue;
    }

    public void setValue(Boolean value) {
        this.unlockValue = value;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
