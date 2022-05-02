package org.jinoware.trader.loader.api;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import lombok.AllArgsConstructor;
import org.jinoware.trader.loader.price.StockPrice;
import org.jinoware.trader.loader.price.daily.DailyPrice;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DailyPricesService {

    AlphaVantage client;


    public List<DailyPrice> findBy(CompanyName company){

        List<StockUnit> stockUnits = fetchStockUnitsFor(company);

        return convertToResult(stockUnits);
    }

    private List<StockUnit> fetchStockUnitsFor(CompanyName companyName) {
        TimeSeriesResponse timeSeriesResponse = client.timeSeries()
                .daily()
                .forSymbol(companyName.getName())
                .outputSize(OutputSize.FULL)
                .fetchSync();

        return  timeSeriesResponse.getStockUnits();
    }

    private List<DailyPrice> convertToResult(List<StockUnit> stockUnits) {
        return stockUnits.stream().map(price -> {
            Date day = Date.from(Instant.parse(price.getDate()));
            StockPrice stockPrice = new StockPrice(
                    price.getOpen(),
                    price.getHigh(),
                    price.getLow(),
                    price.getClose(),
                    price.getVolume());
            return new DailyPrice(day, stockPrice);
        }).collect(Collectors.toList());
    }
}
