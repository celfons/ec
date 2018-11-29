package br.com.vr.services;

public interface RabbitProducer {
    void send(String order);
}
