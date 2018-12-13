package br.com.vr.apis.requests

import com.fasterxml.jackson.annotation.JsonProperty

data class CreatePurchaseCardRequest(
    @JsonProperty("cnpj")
    val cnpj: String?,
    @JsonProperty("purchaseCardType")
    val purchaseCardType: String?,
    @JsonProperty("category")
    val category: String? ,
    @JsonProperty("cashBack")
    val cashBack: Int?,
    @JsonProperty("pat")
    val pat: Boolean?
)
