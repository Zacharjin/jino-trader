package org.jinoware.trader.loader.price.daily;

import lombok.AllArgsConstructor;
import org.jinoware.trader.loader.api.CompanyName;
import org.jinoware.trader.loader.api.DailyPricesService;
import org.jinoware.trader.loader.price.daily.message.DailyCompanyStockPriceHistory;
import org.jinoware.trader.loader.price.daily.message.DailyStockSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DailyStockFetchService {
    private DailyPricesService pricesService;
    private DailyStockSender sender;

    public void fetchDailyStockPrices(CompanyName company){
        DailyCompanyStockPriceHistory stockPrices = fetchStockPricesFor(company);
        store(stockPrices);
        thenSend(stockPrices);
    }

    private DailyCompanyStockPriceHistory fetchStockPricesFor(CompanyName companyName){
        List<DailyPrice> prices = pricesService.findBy(companyName);
        return new DailyCompanyStockPriceHistory(companyName.getName(), prices);
    }

    private void store(DailyCompanyStockPriceHistory prices) {
        //Todo: Implement stock prices persistence
    }

    private void thenSend(DailyCompanyStockPriceHistory prices) {
        sender.send(prices);
    }

}
