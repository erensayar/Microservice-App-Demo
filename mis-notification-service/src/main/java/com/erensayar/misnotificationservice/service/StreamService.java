package com.erensayar.misnotificationservice.service;

import com.erensayar.mscore.notification.NotificationDto;

public interface StreamService {

    void produce(NotificationDto notificationDto);

    NotificationDto consume(NotificationDto notificationDto);

}
