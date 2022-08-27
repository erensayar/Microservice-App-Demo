package com.erensayar.misproductservice.controller;

import com.erensayar.cocCoreMsApp.product.ProductDto;
import com.erensayar.misproductservice.entity.Product;
import com.erensayar.cocCoreMsApp.feignClient.ProductServiceBase;
import com.erensayar.misproductservice.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductController implements ProductServiceBase {

  private final ProductService productService;

  @Override
  public ResponseEntity<List<ProductDto>> getProducts() {
    return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product) {
    return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto updatedProduct) {
    return new ResponseEntity<>(productService.updateProduct(updatedProduct), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<String> deleteProductById(@PathVariable("id") Long id) {
    productService.deleteProductById(id);
    return ResponseEntity.ok(null);
  }
}
