package br.com.vr.integrations.contracts;

import feign.Param;
import feign.RequestLine;
import java.util.List;

public interface Kenan {

    @RequestLine("POST /kenan/{value}")
    void unlockPurchaseCard(@Param("purchaseCardId")String purchaseCardId, @Param("value") Boolean value);

    @RequestLine("POST /kenan/{purchaseCardId}/{days}")
    void extractPurchaseCard(@Param("purchaseCardId")String purchaseCardId, @Param("days") Integer days);

}
