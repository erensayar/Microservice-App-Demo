package com.erensayar.masconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MasConfigServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MasConfigServiceApplication.class, args);
  }

}
