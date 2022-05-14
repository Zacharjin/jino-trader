package org.jinoware.trader.loader.data.daily;

import lombok.AllArgsConstructor;
import org.jinoware.trader.loader.common.model.CompanyName;
import org.jinoware.trader.loader.common.model.Day;
import org.jinoware.trader.loader.common.model.PricePerDay;
import org.jinoware.trader.loader.common.DailyStockStoreService;
import org.jinoware.trader.loader.common.model.StockPrice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

@Service
@AllArgsConstructor
public class DailyStockPriceStoreService implements DailyStockStoreService {

    private DailyPriceRepository repository;

    @Override
    public void store(CompanyName company, PricePerDay data) {
        Day day = data.getDay();

        StockPricesPerDay dailyStock = repository.findById(day)
                .orElse(new StockPricesPerDay(day, null, new ArrayList<>()));

        StockPrice price = data.getPrice();
        dailyStock.addStockPrice(company, price);
        repository.save(dailyStock);
    }

}
