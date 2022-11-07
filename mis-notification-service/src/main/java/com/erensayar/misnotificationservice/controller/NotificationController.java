package com.erensayar.misnotificationservice.controller;

import com.erensayar.misnotificationservice.service.StreamService;
import com.erensayar.mscore.feignClient.NotificationServiceBase;
import com.erensayar.mscore.notification.NotificationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NotificationController implements NotificationServiceBase {

    private final StreamService streamService;

    @Override
    public ResponseEntity<String> pushNotification(NotificationDto notificationDto) {
        streamService.produce(notificationDto);
        return ResponseEntity.ok(null);
    }

}
