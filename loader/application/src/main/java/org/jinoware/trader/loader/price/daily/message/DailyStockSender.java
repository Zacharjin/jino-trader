package org.jinoware.trader.loader.price.daily.message;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DailyStockSender {
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.queue.daily.exchange}")
    private String exchange;
    @Value("${spring.queue.daily.routingkey}")
    private String routingkey;

    public void send(DailyCompanyStockPriceHistory message){
        rabbitTemplate.convertAndSend(exchange,routingkey, message);
    }
}
