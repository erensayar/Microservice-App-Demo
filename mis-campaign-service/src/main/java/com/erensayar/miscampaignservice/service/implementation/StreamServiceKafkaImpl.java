package com.erensayar.miscampaignservice.service.implementation;

import com.erensayar.miscampaignservice.service.StreamService;
import com.erensayar.mscore.notification.NotificationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StreamServiceKafkaImpl implements StreamService {

    @Value("${api.kafka.topic.campaign}")
    private String campaignTopic;

    private final KafkaTemplate<String, NotificationDto> kafkaTemplate;

    @Override
    public void produce(NotificationDto notificationDto) {
        kafkaTemplate.send(campaignTopic, UUID.randomUUID().toString(), notificationDto);
    }

}
