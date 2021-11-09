package com.erensayar.misproductserver.entity.dto.internal;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Long productCategoryId;
}
