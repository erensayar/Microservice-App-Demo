package com.erensayar.coscommonobject.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product-service", url = "${micro-service-demo.apigw.base-url}", configuration = FeignClientConfiguration.class)
public interface UserClient {

    @GetMapping(value = "${micro-service-demo.apigw.user-uri}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getUsers();

    @GetMapping(value = "${micro-service-demo.apigw.user-uri}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getUserById(@PathVariable("id") Long id);

}