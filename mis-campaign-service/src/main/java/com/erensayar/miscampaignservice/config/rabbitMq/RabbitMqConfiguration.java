package com.erensayar.miscampaignservice.config.rabbitMq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class RabbitMqConfiguration {

  private final RabbitMqConstant rabbitMqConstant;

  @Bean
  public DirectExchange directExchange() {
    return new DirectExchange(rabbitMqConstant.getExchange().getDirect());
  }

  @Bean
  public Queue campaignQueue() {
    return new Queue(rabbitMqConstant.getQueue().getCampaign(), true);
  }

  @Bean
  public Binding campaignBinding(final Queue campaignQueue, final DirectExchange directExchange) {
    return BindingBuilder.bind(campaignQueue).to(directExchange).with(rabbitMqConstant.getRoutingKey().getCampaign());
  }


}
