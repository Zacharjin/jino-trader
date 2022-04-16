package org.jinoware.trader.loader.price.daily;

import lombok.AllArgsConstructor;
import org.jinoware.trader.loader.api.CompanyName;
import org.jinoware.trader.loader.api.DailyPricesService;
import org.jinoware.trader.loader.price.daily.DailyPrice;
import org.jinoware.trader.loader.price.daily.message.DailyStockBatch;
import org.jinoware.trader.loader.price.daily.message.DailyStockSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DailyStockFetchService {
    private DailyPricesService pricesService;
    private DailyStockSender sender;

    public void fetchDailyStock(CompanyName companyName){
        List<DailyPrice> prices = pricesService.findBy(companyName);
        persist(prices);
        thenSend(prices);
    }

    private void persist(List<DailyPrice> prices) {

    }

    private void thenSend(List<DailyPrice> prices) {
        DailyStockBatch message = null;
        sender.send(message);
    }

}
