package com.erensayar.miscampaignservice.service.implementation;

/*
import com.erensayar.miscampaignservice.config.rabbitMq.RabbitMqConstant;
import com.erensayar.miscampaignservice.service.StreamService;
import com.erensayar.mscore.notification.NotificationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class StreamServiceRabbitMqImpl implements StreamService {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMqConstant rabbitMqConstant;

    @Override
    public void produce(NotificationDto notificationDto) {
        log.info(notificationDto.toString());
        rabbitTemplate.convertAndSend(
                rabbitMqConstant.getExchange().getDirect(),
                rabbitMqConstant.getRoutingKey().getCampaign(),
                notificationDto);
    }
}
*/