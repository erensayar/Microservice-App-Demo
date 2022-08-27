package com.erensayar.misnotificationservice.service;

import com.erensayar.cocCoreMsApp.notification.NotificationDto;

public interface NotificationService {

  void produce(NotificationDto notificationDto);

  NotificationDto consume(NotificationDto notificationDto);

}
