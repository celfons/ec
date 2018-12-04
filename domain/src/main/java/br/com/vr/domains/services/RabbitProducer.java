package br.com.vr.domains.services;

public interface RabbitProducer {
    void send(String order);
}
