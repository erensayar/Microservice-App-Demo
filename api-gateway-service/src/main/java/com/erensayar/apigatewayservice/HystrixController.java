package com.erensayar.apigatewayservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exc")
public class HystrixController {

  @GetMapping("/users")
  public String userFallback() {
    return "User Service is not available.";
  }

  @GetMapping("/campaigns")
  public String campaignFallback() {
    return "Campaign Service is not available.";
  }

  @GetMapping("/notifications")
  public String notificationFallback() {
    return "Notification Service is not available.";
  }

  @GetMapping("/products")
  public String productFallback() {
    return "Product Service is not available.";
  }

}
