package com.erensayar.misnotificationserver.service;

import java.util.List;

public interface MailService {

    void sendMultipleMail(List<Long> userIdList);

}
