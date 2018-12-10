package br.com.vr.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.vr.apis", "br.com.vr.controllers", "br.com.vr.domains", "br.com.vr.integrations", "br.com.vr.repositories"})
public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        LOGGER.info("Debug Message Logged !!!");
    }


}
