package com.erensayar.misnotificationservice.service.impl;

import com.erensayar.misnotificationservice.service.StreamService;
import com.erensayar.mscore.notification.NotificationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class StreamServiceKafkaImpl implements StreamService {

    @Value("${api.kafka.topic.notification}")
    private String notificationTopic;

    private final KafkaTemplate<String, NotificationDto> kafkaTemplate;

    @Override
    public void produce(NotificationDto notificationDto) {
        kafkaTemplate.send(notificationTopic, UUID.randomUUID().toString(), notificationDto);
    }

    @Override
    @KafkaListener(
            topics = "${api.kafka.topic.campaign}",
            groupId = "${api.kafka.group.id}"
    )
    public NotificationDto consume(@Payload NotificationDto notificationDto) {
        log.info(notificationDto.toString());
        return null; // TODO
    }

}
