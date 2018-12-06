package br.com.vr.apis.responses;

public class UnlockCardResponse {

    private Long purchaseCardId;
    private Boolean unlockValue;

    public UnlockCardResponse(Boolean value, Long cardId) {
        this.unlockValue = value;
        this.purchaseCardId = cardId;
    }

    public Boolean getValue() {
        return unlockValue;
    }

    public void setValue(Boolean value) {
        this.unlockValue = value;
    }

    public Long getCardId() {
        return purchaseCardId;
    }

    public void setCardId(Long cardId) {
        this.purchaseCardId = cardId;
    }

}
