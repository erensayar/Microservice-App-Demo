package com.erensayar.misnotificationserver.service.implementation;

import com.erensayar.misnotificationserver.service.MailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    @Override
    public void sendMultipleMail(List<Long> userIdList) {

    }

}
