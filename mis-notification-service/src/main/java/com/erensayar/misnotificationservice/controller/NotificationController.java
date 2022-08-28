package com.erensayar.misnotificationservice.controller;

import com.erensayar.cocCoreMsApp.feignClient.NotificationServiceBase;
import com.erensayar.cocCoreMsApp.notification.NotificationDto;
import com.erensayar.misnotificationservice.service.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NotificationController implements NotificationServiceBase {

  private final NotificationProducer notificationProducer;

  @Override
  public ResponseEntity<String> pushNotification(NotificationDto notificationDto) {
    notificationProducer.producer(notificationDto);
    return ResponseEntity.ok(null);
  }

}
