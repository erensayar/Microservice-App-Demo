package com.erensayar.miscampaignservice.service;

import com.erensayar.coccoremsapp.notification.NotificationDto;

public interface CampaignNotificationService {

  void pushCampaignNotification(NotificationDto notificationDto);

}
