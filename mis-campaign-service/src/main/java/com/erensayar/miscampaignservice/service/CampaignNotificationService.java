package com.erensayar.miscampaignservice.service;

import com.erensayar.cocCoreMsApp.notification.NotificationDto;

public interface CampaignNotificationService {

  void pushCampaignNotification(NotificationDto notificationDto);

}
