package br.com.vr.apis.responses;

public class UnlockCardResponse {

    private Long cardId;
    private Boolean unlockValue;

    public UnlockCardResponse(Boolean value, Long cardId) {
        this.unlockValue = value;
        this.cardId = cardId;
    }

    public Boolean getValue() {
        return unlockValue;
    }

    public void setValue(Boolean value) {
        this.unlockValue = value;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

}
