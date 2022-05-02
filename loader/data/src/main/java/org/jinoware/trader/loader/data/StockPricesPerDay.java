package org.jinoware.trader.loader.data;

import lombok.Value;
import org.jinoware.trader.loader.api.CompanyName;
import org.jinoware.trader.loader.data.daily.CompanyStockPrice;
import org.jinoware.trader.loader.price.StockPrice;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Document
@Value
public class StockPricesPerDay {
    @Id
    Date day;
    @Version
    Long version;

    List<CompanyStockPrice> summary;

    public void updateDailyPrice(CompanyName company, StockPrice price) {

        Supplier<CompanyStockPrice> provideEmptyStockPrice = () ->
                new CompanyStockPrice(company, StockPrice.createEmpty());

        CompanyStockPrice stock = findStockPriceFor(company)
                .orElseGet(provideEmptyStockPrice);


        boolean stockIsNew = !summary.contains(stock);
        if(stockIsNew){
            summary.add(stock);
        }

        stock.setPrice(price);
    }

    private Optional<CompanyStockPrice> findStockPriceFor(CompanyName companyName) {

        Predicate<CompanyStockPrice> onlyStockDataForSpecifiedCompany = companyData ->
                companyData.getCompanyName().getName()
                        .equalsIgnoreCase(companyName.getName());


        return summary.stream()
                .filter(onlyStockDataForSpecifiedCompany)
                .findFirst();
    }

}
