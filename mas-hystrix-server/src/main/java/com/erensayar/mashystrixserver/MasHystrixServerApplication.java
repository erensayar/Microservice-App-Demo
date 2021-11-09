package com.erensayar.mashystrixserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class MasHystrixServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasHystrixServerApplication.class, args);
    }

}
