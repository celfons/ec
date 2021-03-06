package br.com.vr.controllers.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.vr.apis", "br.com.vr.controllers", "br.com.vr.domains", "br.com.vr.integrations", "br.com.vr.repositories", "br.com.vr.producers"})
public class PurchaseCardApplication {

    private static final Logger LOGGER = LogManager.getLogger(PurchaseCardApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(PurchaseCardApplication.class, args);
        LOGGER.info("Debug Message Logged !!!");
    }


}
