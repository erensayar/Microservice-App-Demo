package com.erensayar.cocCoreMsApp.feignClient;

import com.erensayar.cocCoreMsApp.notification.NotificationDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface NotificationServiceBase {

  @PostMapping(value = "/api/v1/notifications", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<String> pushNotification(@RequestBody NotificationDto notificationDtoList);

}
