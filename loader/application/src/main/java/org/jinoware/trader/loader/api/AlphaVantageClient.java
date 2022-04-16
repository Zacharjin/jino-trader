package org.jinoware.trader.loader.api;

import lombok.Value;
import org.jinoware.trader.loader.stock.ApiConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Value
public class AlphaVantageClient {

    ApiConfig apiKey;
    RestTemplate restTemplate;

    public List<CompanyDailyPrices> getDaily(CompanyName name){
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=demo";
        DailyPrices result = restTemplate.getForObject(url, DailyPrices.class);
        System.out.println(url);
//        HashMap series = (HashMap) result.get("Time Series (Daily)");
        return null;
    }



}
