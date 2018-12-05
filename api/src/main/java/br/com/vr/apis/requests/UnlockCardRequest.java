package br.com.vr.apis.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnlockCardRequest {

    @JsonProperty("cardId") private Long cardId;

    @JsonProperty("unlockValue") private Boolean unlockValue;

    public UnlockCardRequest(Boolean value, Long cardId) {
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
