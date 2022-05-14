package org.jinoware.trader.loader.price.daily.message;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class DailyQueueConfig {


    @Value("${spring.queue.daily.exchange}")
    private String exchange;
    @Value("${spring.queue.daily.routingkey}")
    private String routingKey;
}
