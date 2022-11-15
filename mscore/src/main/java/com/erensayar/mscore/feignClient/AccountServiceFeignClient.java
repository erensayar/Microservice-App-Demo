package com.erensayar.mscore.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MIS-ACCOUNT-SERVICE", contextId = "AccountServiceFeignClient")
public interface AccountServiceFeignClient extends AccountServiceBase {

}
