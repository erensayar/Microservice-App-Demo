package com.erensayar.apigatewayservice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerAutoConfiguration;
import org.springframework.web.reactive.DispatcherHandler;

@ConditionalOnClass({DispatcherHandler.class,
    ReactiveResilience4JAutoConfiguration.class,
    HystrixCircuitBreakerAutoConfiguration.class})
public class GatewayCircuitBreakerAutoConfiguration {

}