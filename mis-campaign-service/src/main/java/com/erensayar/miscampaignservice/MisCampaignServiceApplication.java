package com.erensayar.miscampaignservice;

import com.erensayar.coccoremsapp.feignClient.NotificationServiceFeignClient;
import com.erensayar.coccoremsapp.feignClient.ProductServiceFeignClient;
import com.erensayar.coccoremsapp.feignClient.UserServiceFeignClient;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients(basePackageClasses = {
    ProductServiceFeignClient.class,
    NotificationServiceFeignClient.class,
    UserServiceFeignClient.class
})
@SpringBootApplication
@EnableDiscoveryClient
public class MisCampaignServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MisCampaignServiceApplication.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(AccessLevel.PRIVATE);
    return modelMapper;
  }


}