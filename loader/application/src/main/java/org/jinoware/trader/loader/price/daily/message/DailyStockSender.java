package org.jinoware.trader.loader.price.daily.message;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DailyStockSender {
    private RabbitTemplate rabbitTemplate;
    private DailyQueueConfig queueConfig;

    public void send(DailyCompanyStockPriceHistory message){
        String exchange = queueConfig.getExchange();
        String routingKey = queueConfig.getRoutingKey();
        rabbitTemplate.convertAndSend(exchange,routingKey, message);
    }
}
