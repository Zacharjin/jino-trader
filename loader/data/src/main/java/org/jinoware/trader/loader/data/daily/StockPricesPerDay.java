package org.jinoware.trader.loader.data.daily;

import lombok.Value;
import org.jinoware.trader.loader.api.CompanyName;
import org.jinoware.trader.loader.data.model.UpdatePrice;
import org.jinoware.trader.loader.data.repository.StockPriceRepository;
import org.jinoware.trader.loader.price.StockPrice;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

@Document
@Value
public class StockPricesPerDay {
    @Id
    Date day;
    @Version
    Long version;

    List<DailyCompanyStockEvaluation> pricesPerCompany;

    public void addStockPrice(CompanyName company, StockPrice price) {

        StockPriceRepository<DailyCompanyStockEvaluation> repo = new StockPriceRepository<>(pricesPerCompany);

        Supplier<DailyCompanyStockEvaluation> provideEmptyDailyStockWhenNotFound =
                () -> new DailyCompanyStockEvaluation(company, StockPrice.createEmpty());

        UpdatePrice<DailyCompanyStockEvaluation> thenUpdatePrice = stock -> stock.setPrice(price);

        repo.upsert(company,
                provideEmptyDailyStockWhenNotFound,
                thenUpdatePrice);
    }



}
