package com.erensayar.misproductservice.service.Implementation;

import com.erensayar.coccoremsapp.product.ProductDto;
import com.erensayar.core.error.exception.BadRequestException;
import com.erensayar.core.error.exception.NoContentException;
import com.erensayar.misproductservice.entity.Product;
import com.erensayar.misproductservice.repository.ProductRepository;
import com.erensayar.misproductservice.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final ModelMapper modelMapper;


  @Override
  public List<ProductDto> getProducts() {
    List<Product> productList = productRepository.findAll();
    return productList
        .stream()
        .map(element -> modelMapper.map(element, ProductDto.class))
        .collect(Collectors.toList());
  }

  @Override
  public ProductDto getProductById(Long id) {
    Product product = productRepository.findById(id).orElseThrow(NoContentException::new);
    return modelMapper.map(product, ProductDto.class);
  }

  @Override
  public ProductDto createProduct(ProductDto productDto) {
    if (productDto.getId() != null) {
      throw new BadRequestException();
    }
    return saveProduct(productDto);
  }

  private ProductDto saveProduct(ProductDto productDto) {
    Product product = modelMapper.map(productDto, Product.class);
    Product savedProduct = productRepository.save(product);
    return modelMapper.map(savedProduct, ProductDto.class);
  }

  @Override
  public ProductDto updateProduct(ProductDto productDto) {
    productRepository.findById(productDto.getId()).orElseThrow(BadRequestException::new);
    return saveProduct(productDto);
  }

  @Override
  public void deleteProductById(Long id) {
    if (productRepository.findById(id).isEmpty()) {
      throw new BadRequestException();
    }
    productRepository.deleteById(id);
  }

}
