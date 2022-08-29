package com.erensayar.misproductservice.component;

import com.erensayar.misproductservice.entity.Product;
import com.erensayar.misproductservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CmdLineRunner implements CommandLineRunner {

  private final ProductRepository productRepository;

  @Override
  public void run(String... args) throws Exception {

    Product product1 = productRepository.save(Product.builder()
        .id(1L)
        .name("Product-1")
        .description("Product-1-Description")
        .build());

    Product product2 = productRepository.save(Product.builder()
        .id(2L)
        .name("Product-2")
        .description("Product-2-Description")
        .build());

    Product product3 = productRepository.save(Product.builder()
        .id(3L)
        .name("Product-3")
        .description("Product-3-Description")
        .build());

    Product product4 = productRepository.save(Product.builder()
        .id(4L)
        .name("Product-4")
        .description("Product-4-Description")
        .build());

    Product product5 = productRepository.save(Product.builder()
        .id(5L)
        .name("Product-5")
        .description("Product-5-Description")
        .build());

  }
}
