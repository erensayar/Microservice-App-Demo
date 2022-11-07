package com.erensayar.miscampaignservice.service;

import com.erensayar.mscore.notification.NotificationDto;

public interface StreamService {

    void produce(NotificationDto notificationDto);

}
