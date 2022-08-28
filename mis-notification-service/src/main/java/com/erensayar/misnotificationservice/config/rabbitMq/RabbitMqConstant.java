package com.erensayar.misnotificationservice.config.rabbitMq;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "api.rabbit-mq")
public class RabbitMqConstant {

  private Exchange exchange;
  private Queue queue;
  private RoutingKey routingKey;

  @Getter
  @Setter
  public static class Exchange {
    private String direct;
    private String topic;
  }

  @Getter
  @Setter
  public static class Queue {
    private String campaign;
    private String notification;
  }

  @Getter
  @Setter
  public static class RoutingKey {
    private String campaign;
    private String notification;
  }

}
