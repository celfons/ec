package br.com.vr.apis.requests

import com.fasterxml.jackson.annotation.JsonProperty

data class ExtractPurchaseCardRequest(
    @JsonProperty("purchaseCardId")
    val purchaseCardId: String?,
    @JsonProperty("days")
    val days: Int?
)