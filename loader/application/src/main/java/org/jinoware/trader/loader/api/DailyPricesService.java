package org.jinoware.trader.loader.api;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DailyPricesService {

    AlphaVantage alphaVantage;


    public void findBy(CompanyName companyName){
        TimeSeriesResponse timeSeriesResponse = alphaVantage.timeSeries()
                .daily()
                .forSymbol(companyName.getName())
                .outputSize(OutputSize.FULL)
                .fetchSync();
        List<StockUnit> stockUnits = timeSeriesResponse.getStockUnits();


    }
}
