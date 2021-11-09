package com.erensayar.coscommonobject.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "campaign-service", url = "${micro-service-demo.apigw.base-url}", configuration = FeignClientConfiguration.class)
public interface CampaignClient {

    @GetMapping(value = "${micro-service-demo.apigw.campaign-uri}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getCampaigns();

    @GetMapping(value = "${micro-service-demo.apigw.campaign-uri}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getCampaignById(@PathVariable("id") Long id);
}