package com.erensayar.coccoremsapp.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MIS-PRODUCT-SERVICE", contextId = "ProductServiceFeignClient")
public interface ProductServiceFeignClient extends ProductServiceBase {

}
