package com.erensayar.misproductserver.service;

import com.erensayar.misproductserver.entity.Product;
import com.erensayar.misproductserver.entity.dto.internal.ProductDto;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(Long id);

    Product createProduct(ProductDto productDto);

    Product updateProduct(ProductDto productDto);

    void deleteProductById(Long id);

}
