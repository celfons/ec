package br.com.vr.domains.services;

public interface KenanService {

    void unlockPurchaseCard(String purchaseCardId, Boolean value);

    void extractPurchaseCard(String purchaseCardId, Integer days);

}
