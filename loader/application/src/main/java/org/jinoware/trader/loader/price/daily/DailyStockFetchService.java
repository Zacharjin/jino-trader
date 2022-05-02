package org.jinoware.trader.loader.price.daily;

import lombok.AllArgsConstructor;
import org.jinoware.trader.loader.api.CompanyName;
import org.jinoware.trader.loader.api.DailyPricesService;
import org.jinoware.trader.loader.price.daily.message.DailyCompanyStockPriceHistory;
import org.jinoware.trader.loader.price.daily.message.DailyStockSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DailyStockFetchService {
    private DailyPricesService pricesService;
    private DailyStockSender sender;
    private DailyStockStoreService stockStoreService;
    public void fetchDailyStockPrices(CompanyName company){
        DailyCompanyStockPriceHistory stockPrices = fetchStockPricesFor(company);
        store(stockPrices);
        thenSend(stockPrices);
    }

    private DailyCompanyStockPriceHistory fetchStockPricesFor(CompanyName companyName){
        List<DailyPrice> prices = pricesService.findBy(companyName);
        return new DailyCompanyStockPriceHistory(companyName, prices);
    }

    private void store(DailyCompanyStockPriceHistory stocks) {
        stocks.getData()
                .forEach(data-> stockStoreService.store(stocks.getCompanyName(), data));

    }

    private void thenSend(DailyCompanyStockPriceHistory prices) {
        sender.send(prices);
    }



    private Map<Date, DailyPrice> groupByDay(List<DailyPrice> data) {
        return data.stream()
                .collect(Collectors.toMap(DailyPrice::getDay, v -> v));
    }
}
