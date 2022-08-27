package com.erensayar.cocCoreMsApp.feignClient;

import com.erensayar.cocCoreMsApp.product.ProductDto;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductServiceBase {

  @GetMapping(value = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<ProductDto>> getProducts();

  @GetMapping(value = "/api/v1/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id);

  @PostMapping(value = "/api/v1/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product);

  @PutMapping(value = "/api/v1/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto updatedProduct);

  @DeleteMapping(value = "/api/v1/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<String> deleteProductById(@PathVariable("id") Long id);

}
