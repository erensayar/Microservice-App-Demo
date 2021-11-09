package com.erensayar.misuserserver.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String products;
}
