package com.erensayar.misproductservice.service;

import com.erensayar.cocCoreMsApp.product.ProductDto;
import java.util.List;

public interface ProductService {

  List<ProductDto> getProducts();

  ProductDto getProductById(Long id);

  ProductDto createProduct(ProductDto productDto);

  ProductDto updateProduct(ProductDto productDto);

  void deleteProductById(Long id);

}
