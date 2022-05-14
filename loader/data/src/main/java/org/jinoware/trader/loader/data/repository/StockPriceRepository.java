package org.jinoware.trader.loader.data.repository;

import lombok.AllArgsConstructor;
import org.jinoware.trader.loader.common.model.CompanyName;
import org.jinoware.trader.loader.data.model.IdentifiableByCompanyName;
import org.jinoware.trader.loader.data.model.UpdatePrice;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
@AllArgsConstructor
public class StockPriceRepository<T extends IdentifiableByCompanyName> {

    List<T> data;

    public void insertOrUpdate(CompanyName company,
                               Supplier<T> provideEmptyStockPrice,
                               UpdatePrice<T> operation){

        T found = find(company)
                .orElseGet(provideEmptyStockPrice);

        operation.changePrice(found);

        save(found);
    }


    private Optional<T> find(CompanyName company){
        return findStockPriceFor(company);
    }

    private void save(T stock) {
        boolean companyIsNew = !find(stock.getCompanyName()).isPresent();
        if(companyIsNew) {
            data.add(stock);
        }
    }

    private Optional<T> findStockPriceFor(CompanyName companyName) {

        Predicate<T> onlyStockDataForSpecifiedCompany = companyData ->
                companyData.getCompanyName().getName()
                        .equalsIgnoreCase(companyName.getName());


        return data.stream()
                .filter(onlyStockDataForSpecifiedCompany)
                .findFirst();
    }
}
