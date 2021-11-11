package com.erensayar.misnotificationserver.service;

import java.util.List;

public interface PushNotificationService {

    void sendPushNotifications(List<Long> userIdList);

}
