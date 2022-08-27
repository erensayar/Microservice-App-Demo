package com.erensayar.misnotificationservice.service;

import com.erensayar.cocCoreMsApp.notification.NotificationDto;

public interface NotificationService {

  void pushNotification(NotificationDto notificationDtoList);

}
