package br.com.vr.domains.services;

public interface RabbitProducerService {

    void send(String purchaseCardId);

}
