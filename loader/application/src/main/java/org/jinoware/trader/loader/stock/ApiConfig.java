package org.jinoware.trader.loader.stock;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApiConfig {

    @Value("#{environment.API_KEY}")
    private String apiKey;


    @Bean
    public AlphaVantage api(){
        Config cfg = Config.builder()
                .key(apiKey)
                .timeOut(10)
                .build();
        AlphaVantage api = AlphaVantage.api();
         api.init(cfg);
        return api;
    }
}
