package br.com.vr.apis

import br.com.vr.apis.requests.CreatePurchaseCardRequest
import br.com.vr.apis.requests.ExtractPurchaseCardRequest
import br.com.vr.apis.requests.UnlockPurchaseCardRequest
import br.com.vr.apis.responses.CreatePurchaseCardResponse
import br.com.vr.apis.responses.ExtractPurchaseCardResponse
import br.com.vr.apis.responses.UnlockCardResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

interface PurchaseCardApi {

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @RequestMapping(value = ["/purchase-card"], method = [RequestMethod.POST])
    fun createPurchaseCard(@RequestBody @Valid createPurchaseCardRequest: CreatePurchaseCardRequest): CreatePurchaseCardResponse

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = ["/unlock"], method = [RequestMethod.POST])
    fun unlockPurchaseCard(@RequestBody @Valid unlockPurchaseCardRequest: UnlockPurchaseCardRequest): UnlockCardResponse

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = ["/extract"], method = [RequestMethod.POST])
    fun extractPurchaseCard(@RequestBody @Valid extractPurchaseCardRequest: ExtractPurchaseCardRequest): ExtractPurchaseCardResponse

}
