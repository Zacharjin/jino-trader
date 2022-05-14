package org.jinoware.trader.loader.price.daily;

import lombok.AllArgsConstructor;
import lombok.val;
import org.jinoware.trader.loader.common.model.CompanyName;
import org.jinoware.trader.loader.api.DailyPricesService;
import org.jinoware.trader.loader.common.DailyStockStoreService;
import org.jinoware.trader.loader.common.model.PricePerDay;
import org.jinoware.trader.loader.price.daily.message.DailyCompanyStockPriceHistory;
import org.jinoware.trader.loader.price.daily.message.DailyStockSender;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .forEach(data-> {
                    val pricePerDay = new PricePerDay(data.getDay(), data.getPrice());
                    stockStoreService.store(stocks.getCompanyName(), pricePerDay);
                });

    }

    private void thenSend(DailyCompanyStockPriceHistory prices) {
        sender.send(prices);
    }


}
