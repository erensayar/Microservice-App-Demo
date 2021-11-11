package com.erensayar.misnotificationserver.service.implementation;

import com.erensayar.misnotificationserver.service.PushNotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushNotificationServiceImpl implements PushNotificationService {

    @Override
    public void sendPushNotifications(List<Long> userIdList) {

    }

}
