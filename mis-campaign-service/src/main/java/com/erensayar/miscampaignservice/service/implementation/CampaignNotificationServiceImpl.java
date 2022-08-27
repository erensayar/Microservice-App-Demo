package com.erensayar.miscampaignservice.service.implementation;

import com.erensayar.cocCoreMsApp.notification.NotificationDto;
import com.erensayar.miscampaignservice.service.CampaignNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class CampaignNotificationServiceImpl implements CampaignNotificationService {

  private final Source source;

  @Override
  public void pushCampaignNotification(NotificationDto notificationDto) {
    source.output().send(MessageBuilder.withPayload(notificationDto).build());
  }

}
