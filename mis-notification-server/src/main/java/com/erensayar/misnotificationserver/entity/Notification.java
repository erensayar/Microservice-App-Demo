package com.erensayar.misnotificationserver.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notification {
    private String title;
    private String message;
}
