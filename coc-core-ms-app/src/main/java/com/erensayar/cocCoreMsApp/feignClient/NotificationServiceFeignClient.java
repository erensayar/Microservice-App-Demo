package com.erensayar.cocCoreMsApp.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MIS-NOTIFICATION-SERVICE", contextId = "NotificationServiceFeignClient")
public interface NotificationServiceFeignClient extends NotificationServiceBase {

}
