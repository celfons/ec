package br.com.vr.integrations;

import br.com.vr.domains.services.KenanService;
import br.com.vr.integrations.contracts.Kenan;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class KenanIntegration implements KenanService {

    @Value("${url.kenan}")
    private String urlKenan;

    private Kenan kenan;

    @PostConstruct
    public void init() {
        kenan = Feign.builder()
                .client(new OkHttpClient())
                .logger(new Slf4jLogger())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(Kenan.class, urlKenan);
    }

    @Override
    public void unlockPurchaseCard(String purchaseCardId, Boolean value){
        kenan.unlockPurchaseCard(purchaseCardId, value);
    }

    @Override
    public void extractPurchaseCard(String purchaseCardId, Integer days) {
        kenan.extractPurchaseCard(purchaseCardId, days);
    }

}
