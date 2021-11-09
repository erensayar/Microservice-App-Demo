package com.erensayar.coscommonobject.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "notification-service", url = "${micro-service-demo.apigw.base-url}", configuration = FeignClientConfiguration.class)
public interface NotificationClient {

    @GetMapping(value = "${micro-service-demo.apigw.notification-uri}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getNotifications();

    @GetMapping(value = "${micro-service-demo.apigw.notification-uri}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getNotificationById(@PathVariable("id") Long id);

}