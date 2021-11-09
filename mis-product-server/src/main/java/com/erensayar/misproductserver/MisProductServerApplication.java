package com.erensayar.misproductserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MisProductServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MisProductServerApplication.class, args);
    }

}
