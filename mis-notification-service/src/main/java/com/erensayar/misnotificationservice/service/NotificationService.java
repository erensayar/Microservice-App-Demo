package com.erensayar.misnotificationservice.service;

import com.erensayar.cocCoreMsApp.notification.NotificationDto;

public interface NotificationService {

  void producer(NotificationDto notificationDto);

  //NotificationDto consumer(NotificationDto notificationDto);
  //NotificationDto consumer(String x);

}
