package com.erensayar.misnotificationservice.controller;

import com.erensayar.cocCoreMsApp.feignClient.NotificationServiceBase;
import com.erensayar.cocCoreMsApp.notification.NotificationDto;
import com.erensayar.misnotificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NotificationController implements NotificationServiceBase {

  private final NotificationService notificationService;

  @Override
  public ResponseEntity<String> pushNotification(NotificationDto notificationDtoList) {
    notificationService.pushNotification(notificationDtoList);
    return ResponseEntity.ok(null);
  }
}
