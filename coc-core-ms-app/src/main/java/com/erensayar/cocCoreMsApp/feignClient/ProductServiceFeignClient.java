package com.erensayar.cocCoreMsApp.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MIS-PRODUCT-SERVICE", contextId = "ProductServiceFeignClient")
public interface ProductServiceFeignClient extends ProductServiceBase {

}
