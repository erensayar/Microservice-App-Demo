package com.erensayar.misuserservice;

import com.erensayar.cocCoreMsApp.feignClient.CampaignServiceFeignClient;
import com.erensayar.cocCoreMsApp.feignClient.NotificationServiceFeignClient;
import com.erensayar.cocCoreMsApp.feignClient.ProductServiceFeignClient;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients(basePackageClasses = {
    ProductServiceFeignClient.class,
    NotificationServiceFeignClient.class,
    CampaignServiceFeignClient.class
})
@SpringBootApplication
public class MisUserServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MisUserServiceApplication.class, args);
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
