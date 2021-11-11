package com.erensayar.misnotificationserver.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Mail {
    private String to;
    private String subject;
    private String body;
    private List<String> cc;
    private List<String> bcc;
}
