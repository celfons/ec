package br.com.vr.apis.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnlockCardRequest {

    @JsonProperty("purchaseCardId") private Long purchaseCardId;

    @JsonProperty("unlockValue") private Boolean unlockValue;

    public UnlockCardRequest(Boolean value, Long cardId) {
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
