package com.erensayar.misnotificationserver.service.implementation;

import com.erensayar.misnotificationserver.service.BaseInformationService;
import com.erensayar.misnotificationserver.service.MailService;
import com.erensayar.misnotificationserver.service.PushNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BaseInformationServiceImpl implements BaseInformationService {

    private final MailService mailService;
    private final PushNotificationService pushNotificationService;

    @Override
    public void informToSubscribers(String prodList) {

    }

}
