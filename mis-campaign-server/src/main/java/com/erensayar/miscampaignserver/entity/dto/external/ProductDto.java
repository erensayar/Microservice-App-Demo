package com.erensayar.miscampaignserver.entity.dto.external;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
}
