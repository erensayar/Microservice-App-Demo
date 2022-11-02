package com.erensayar.misnotificationservice.service.impl;

/*
import com.erensayar.misnotificationservice.service.StreamService;
import com.erensayar.mscore.notification.NotificationDto;
import com.erensayar.misnotificationservice.config.rabbitMq.RabbitMqConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class StreamServiceRabbitMqImpl implements StreamService {

  private final RabbitTemplate rabbitTemplate;
  private final RabbitMqConstant rabbitMqConstant;


    @Override
    public void produce(NotificationDto notificationDto) {
        log.info(notificationDto.toString());
        rabbitTemplate.convertAndSend(
                rabbitMqConstant.getExchange().getTopic(),
                rabbitMqConstant.getRoutingKey().getNotification(),
                notificationDto);
    }


    @Override
    @RabbitListener(queues = {"${api.rabbit-mq.queue.campaign}"})
    public NotificationDto consume(NotificationDto notificationDto) {
        log.info("Campaigns Received : " + notificationDto.toString());
        return null;
        // TODO : Implementation
    }

}
 */
