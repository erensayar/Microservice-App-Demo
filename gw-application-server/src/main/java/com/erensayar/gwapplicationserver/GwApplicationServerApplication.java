package com.erensayar.gwapplicationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GwApplicationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GwApplicationServerApplication.class, args);
    }

}
