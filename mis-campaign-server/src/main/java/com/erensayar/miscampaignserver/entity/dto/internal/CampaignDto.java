package com.erensayar.miscampaignserver.entity.dto.internal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampaignDto {
    private Long id;
    private String name;
    private String description;
    private Boolean isGeneral;
    private String products;
}
