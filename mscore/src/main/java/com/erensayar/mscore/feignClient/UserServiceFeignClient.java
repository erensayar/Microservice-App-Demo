package com.erensayar.mscore.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MIS-USER-SERVICE", contextId = "UserServiceFeignClient")
public interface UserServiceFeignClient extends UserServiceBase {

}
