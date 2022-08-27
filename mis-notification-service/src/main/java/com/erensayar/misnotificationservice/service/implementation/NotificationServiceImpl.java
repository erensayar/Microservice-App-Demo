package com.erensayar.misnotificationservice.service.implementation;

import com.erensayar.cocCoreMsApp.notification.NotificationDto;
import com.erensayar.misnotificationservice.service.NotificationService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationServiceImpl implements NotificationService {


  @Override
  @StreamListener(Sink.INPUT)
  public void pushNotification(NotificationDto notificationDtoList) {
    System.out.println("Notifications sending...");
    // TODO : Implementation
  }

}
