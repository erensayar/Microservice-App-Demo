package com.erensayar.misnotificationservice.config.rabbitMq;

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
  public TopicExchange topicExchange() {
    return new TopicExchange(rabbitMqConstant.getExchange().getTopic());
  }

  // Campaign
  @Bean
  public Queue campaignQueue() {
    return new Queue(rabbitMqConstant.getQueue().getCampaign(), true);
  }

  @Bean
  public Binding campaignBinding(final Queue campaignQueue, final DirectExchange directExchange) {
    return BindingBuilder.bind(campaignQueue).to(directExchange).with(rabbitMqConstant.getRoutingKey().getCampaign());
  }

  // Notification
  @Bean
  public Queue notificationQueue() {
    return new Queue(rabbitMqConstant.getQueue().getCampaign(), true);
  }

  @Bean
  public Binding notificationBinding(final Queue notificationQueue, final TopicExchange topicExchange) {
    return BindingBuilder.bind(notificationQueue).to(topicExchange).with(rabbitMqConstant.getRoutingKey().getNotification());
  }

    /*
  private final GenericWebApplicationContext context;
  public void instanceBuilder(String queueName, String exchangeName, String routingName) {
    context.registerBean("queueBean", Queue.class, () -> new Queue(queueName, true));
    context.registerBean("directExchangeBean", DirectExchange.class, () -> new DirectExchange(exchangeName));
    context.registerBean("bindingBean", Binding.class, () -> {
      Queue queue = context.getBean(Queue.class);
      DirectExchange directExchange = context.getBean(DirectExchange.class);
      return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    });
  }
  */

}
