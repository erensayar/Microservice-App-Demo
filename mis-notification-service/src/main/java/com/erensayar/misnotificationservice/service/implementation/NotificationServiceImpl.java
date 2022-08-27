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
  public NotificationDto consume(NotificationDto notificationDto) {
    System.out.println("Campaigns received...");
    System.out.println(notificationDto.toString());
    return null;
    // TODO : Implementation
  }

  @Override
  public void produce(NotificationDto notificationDto) {
    // TODO
  }


}
