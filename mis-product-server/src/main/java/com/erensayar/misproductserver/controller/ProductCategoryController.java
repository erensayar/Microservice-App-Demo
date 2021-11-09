package com.erensayar.misproductserver.controller;

import com.erensayar.misproductserver.entity.dto.internal.ProductCategoryDto;
import com.erensayar.misproductserver.service.ProductCategoryService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "Product Category REST API Documentation")
@RequestMapping("/api/v1/productCategories")
@RequiredArgsConstructor
@RestController
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProductCategories() {
        return new ResponseEntity<>(productCategoryService.getProductCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProductCategoryById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productCategoryService.getProductCategoryById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProductCategory(@RequestBody ProductCategoryDto productCategoryDto) {
        return new ResponseEntity<>(productCategoryService.createProductCategory(productCategoryDto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProductCategory(@RequestBody ProductCategoryDto updatedProductCategory) {
        return new ResponseEntity<>(productCategoryService.updateProductCategory(updatedProductCategory), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteProductCategoryById(@PathVariable("id") Long id) {
        productCategoryService.deleteProductCategoryById(id);
        return ResponseEntity.ok(null);
    }

}
