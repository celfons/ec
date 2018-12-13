package br.com.vr.apis.responses

class CreatePurchaseCardResponse(
    val purchaseCardId: String?,
    val cnpj: String?,
    val purchaseCardType: String?,
    val category: String?,
    val cashBack: Int?,
    val pat: Boolean?
)