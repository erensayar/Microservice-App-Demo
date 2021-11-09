package com.erensayar.maseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MasEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasEurekaServerApplication.class, args);
    }

}
