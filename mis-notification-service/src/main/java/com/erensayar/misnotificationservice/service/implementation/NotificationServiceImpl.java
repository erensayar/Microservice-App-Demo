package com.erensayar.misnotificationservice.service.implementation;

import com.erensayar.cocCoreMsApp.notification.NotificationDto;
import com.erensayar.misnotificationservice.config.rabbitMq.RabbitMqConstant;
import com.erensayar.misnotificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

  private final RabbitTemplate rabbitTemplate;
  private final RabbitMqConstant rabbitMqConstant;

  @Override
  public void producer(NotificationDto notificationDto) {
    log.info(notificationDto.toString());
    rabbitTemplate.convertAndSend(
        rabbitMqConstant.getExchange().getTopic(),
        rabbitMqConstant.getRoutingKey().getNotification(),
        notificationDto);
  }


}
