package org.jinoware.trader.loader.data.temporal;

import lombok.Value;
import org.jinoware.trader.loader.common.model.CompanyName;
import org.jinoware.trader.loader.common.model.StockPrice;
import org.jinoware.trader.loader.data.model.UpdatePrice;
import org.jinoware.trader.loader.data.repository.StockPriceRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

@Document
@Value
public class TemporalStockPerDay {
    @Id
    Date day;
    @Version
    Long version;

    List<TemporalCompanyStockEvaluation> pricesPerCompany;

    public void addStockPrice(CompanyName company, Date time, StockPrice price) {

        StockPriceRepository<TemporalCompanyStockEvaluation> repo = new StockPriceRepository<>(pricesPerCompany);

        Supplier<TemporalCompanyStockEvaluation> provideWhenNotFound =
                () -> new TemporalCompanyStockEvaluation(company, new ArrayList<>());

        UpdatePrice<TemporalCompanyStockEvaluation> thenUpdate = stock -> {
            StockTick tick = new StockTick(time, price);
            stock.getTicks().add(tick);
        };

        repo.insertOrUpdate(company,
                provideWhenNotFound,
                thenUpdate);
    }
}
