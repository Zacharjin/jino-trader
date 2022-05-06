package org.jinoware.trader.loader.data.daily;

import lombok.AllArgsConstructor;
import org.jinoware.trader.loader.api.CompanyName;
import org.jinoware.trader.loader.price.StockPrice;
import org.jinoware.trader.loader.price.daily.DailyPrice;
import org.jinoware.trader.loader.price.daily.DailyStockStoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
@AllArgsConstructor
public class DailyStockPriceStoreService implements DailyStockStoreService {

    private DailyPriceRepository repository;

    @Override
    public void store(CompanyName company, DailyPrice data) {
        Date day = data.getDay();
        StockPricesPerDay dailyStock = repository.findById(day)
                .orElse(new StockPricesPerDay(day, 0L, new ArrayList<>()));

        StockPrice price = data.getPrice();
        dailyStock.addStockPrice(company, price);
        repository.save(dailyStock);
    }

}
