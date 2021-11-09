package com.erensayar.misproductserver.service;

import com.erensayar.misproductserver.entity.ProductCategory;
import com.erensayar.misproductserver.entity.dto.internal.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getProductCategories();

    ProductCategory getProductCategoryById(Long id);

    ProductCategory createProductCategory(ProductCategoryDto productCategoryDto);

    ProductCategory updateProductCategory(ProductCategoryDto productCategoryDto);

    void deleteProductCategoryById(Long id);


}
