package com.erensayar.miscampaignservice;

import com.erensayar.mscore.feignClient.NotificationServiceFeignClient;
import com.erensayar.mscore.feignClient.ProductServiceFeignClient;
import com.erensayar.mscore.feignClient.UserServiceFeignClient;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableBinding(value = {NotificationDtoBinder.class})
@EnableFeignClients(basePackageClasses = {
    ProductServiceFeignClient.class,
    NotificationServiceFeignClient.class,
    UserServiceFeignClient.class
})
@SpringBootApplication
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