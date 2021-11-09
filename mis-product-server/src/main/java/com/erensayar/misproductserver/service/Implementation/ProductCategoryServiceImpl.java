package com.erensayar.misproductserver.service.Implementation;

import com.erensayar.coscommonobject.httpStatus.Status_204;
import com.erensayar.coscommonobject.httpStatus.Status_400;
import com.erensayar.misproductserver.entity.Product;
import com.erensayar.misproductserver.entity.ProductCategory;
import com.erensayar.misproductserver.entity.dto.internal.ProductCategoryDto;
import com.erensayar.misproductserver.entity.dto.internal.ProductDto;
import com.erensayar.misproductserver.repository.ProductCategoryRepository;
import com.erensayar.misproductserver.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getProductCategories() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        if (productCategories.isEmpty()) {
            throw new Status_204();
        } else {
            return productCategories;
        }
    }

    @Override
    public ProductCategory getProductCategoryById(Long id) {
        Optional<ProductCategory> optProductCategory = productCategoryRepository.findById(id);
        if (optProductCategory.isPresent()) {
            return optProductCategory.get();
        } else {
            throw new Status_204();
        }
    }

    @Override
    public ProductCategory createProductCategory(ProductCategoryDto productCategoryDto) {
        if (productCategoryDto.getId() != null) {
            throw new Status_400();
        }
        return productCategoryRepository.save(converter(productCategoryDto));
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategoryDto productCategoryDto) {
        if (productCategoryDto.getId() == null) {
            throw new Status_400();
        }
        if (productCategoryRepository.findById(productCategoryDto.getId()).isPresent()) {
            return productCategoryRepository.save(converter(productCategoryDto));
        } else {
            throw new Status_204();
        }
    }

    @Override
    public void deleteProductCategoryById(Long id) {
        if (productCategoryRepository.findById(id).isPresent()) {
            productCategoryRepository.deleteById(id);
        } else {
            throw new Status_204();
        }
    }

    /**
     * This is necessary because we cant create and update process with original object, directly.
     * We need take dto then create real object. Otherwise it can cause be vulnerability.
     */
    private ProductCategory converter(ProductCategoryDto productCategoryDto) {
        return ProductCategory.builder()
                .id(productCategoryDto.getId())
                .name(productCategoryDto.getName())
                .shortCategoryTag(productCategoryDto.getShortCategoryTag())
                .build();
    }

}
