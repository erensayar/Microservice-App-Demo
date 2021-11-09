package com.erensayar.misproductserver.service.Implementation;

import com.erensayar.coscommonobject.httpStatus.Status_204;
import com.erensayar.coscommonobject.httpStatus.Status_400;
import com.erensayar.misproductserver.entity.Product;
import com.erensayar.misproductserver.entity.dto.internal.ProductDto;
import com.erensayar.misproductserver.repository.ProductRepository;
import com.erensayar.misproductserver.service.ProductCategoryService;
import com.erensayar.misproductserver.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryService productCategoryService;

    @Override
    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new Status_204();
        } else {
            return products;
        }
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(Status_204::new);
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        if (productDto.getId() != null) {
            throw new Status_400();
        }
        return productRepository.save(converter(productDto));
    }

    @Override
    public Product updateProduct(ProductDto productDto) {
        if (productDto.getId() == null) {
            throw new Status_400();
        }
        if (productRepository.findById(productDto.getId()).isPresent()) {
            return productRepository.save(converter(productDto));
        } else {
            throw new Status_204();
        }
    }

    @Override
    public void deleteProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new Status_204();
        }
    }

    /**
     * This is necessary because we cant create and update process with original object, directly.
     * We need take dto then create real object. Otherwise it can cause be vulnerability.
     */
    private Product converter(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .description(productDto.getDescription())
                .name(productDto.getName())
                .productCategory(productCategoryService.getProductCategoryById(productDto.getProductCategoryId()))
                .build();
    }

}
