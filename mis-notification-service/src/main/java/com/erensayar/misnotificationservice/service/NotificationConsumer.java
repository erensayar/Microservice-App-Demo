package com.erensayar.misnotificationservice.service;

import com.erensayar.cocCoreMsApp.notification.NotificationDto;
import com.erensayar.misnotificationservice.config.rabbitMq.RabbitMqConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationConsumer {

  private final RabbitTemplate rabbitTemplate;
  private final RabbitMqConstant rabbitMqConstant;

  //@RabbitListener(queues = {"${api.rabbit-mq.queue.campaign}"})
  @RabbitListener(queues = "ms.api.campaign-query")
  public NotificationDto consumer(String x) {
    System.out.println(x);
    //log.info("Campaigns Received : " + notificationDto.toString());
    return null;
    // TODO : Implementation
  }


}
