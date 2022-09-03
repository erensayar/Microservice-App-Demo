package com.erensayar.miscampaignservice.service.implementation;

import com.erensayar.coccoremsapp.notification.NotificationDto;
import com.erensayar.miscampaignservice.config.rabbitMq.RabbitMqConstant;
import com.erensayar.miscampaignservice.service.CampaignNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CampaignNotificationServiceImpl implements CampaignNotificationService {

  private final RabbitTemplate rabbitTemplate;
  private final RabbitMqConstant rabbitMqConstant;

  public void pushCampaignNotification(NotificationDto notificationDto) {
    log.info(notificationDto.toString());
    rabbitTemplate.convertAndSend(
        rabbitMqConstant.getExchange().getDirect(),
        rabbitMqConstant.getRoutingKey().getCampaign(),
        notificationDto);
  }

}
