package com.erensayar.misnotificationservice.service;

import com.erensayar.coccoremsapp.notification.NotificationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationConsumer {

  @RabbitListener(queues = {"${api.rabbit-mq.queue.campaign}"})
  public NotificationDto consumer(NotificationDto notificationDto) {
    log.info("Campaigns Received : " + notificationDto.toString());
    return null;
    // TODO : Implementation
  }


}
