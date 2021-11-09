package com.erensayar.maszipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class MasZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasZipkinServerApplication.class, args);
    }

}
