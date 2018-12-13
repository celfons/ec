package br.com.vr.apis.requests

import com.fasterxml.jackson.annotation.JsonProperty

data class UnlockPurchaseCardRequest(
    @JsonProperty("purchaseCardId")
    val purchaseCardId: String?,
    @JsonProperty("unlockValue")
    val unlockValue: Boolean?
)