package org.jinoware.trader.loader.data;

import org.jinoware.trader.loader.BaseIntegrationTest;
import org.jinoware.trader.loader.common.DailyStockStoreService;
import org.jinoware.trader.loader.common.model.CompanyName;
import org.jinoware.trader.loader.common.model.Day;
import org.jinoware.trader.loader.common.model.PricePerDay;
import org.jinoware.trader.loader.common.model.StockPrice;
import org.jinoware.trader.loader.data.daily.DailyPriceRepository;
import org.jinoware.trader.loader.data.daily.StockPricesPerDay;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDailyStoreTest extends BaseIntegrationTest {

    @Autowired
    DailyStockStoreService service;

    @Autowired
    DailyPriceRepository repository;


    @Test
    public void testStorage(){
        //given
        CompanyName company = firstCompany();
        Day day = firstDay();
        //when
        store(company, price(day, stockPrice()));
        //then
        StockPricesPerDay stock = findStocksBy(day);
        assertEquals(1, stock.getPricesPerCompany().size());
    }


    @Test
    public void testStorage_onMultipleDays(){
        //given
        Stream<CompanyName> companies = companies(10);

        //when
        companies.forEach(company->
                        days(10).forEach(day ->
                                store(company, price(day, stockPrice())))
        );

        //then
        Integer sumOfDataPoints = days(10)
                .map(day -> findStocksBy(day).getPricesPerCompany().size())
                .reduce(0, Integer::sum);
        assertEquals(100, sumOfDataPoints);
    }

    private Stream<CompanyName> companies(int i) {
        return range(0, i)
                .boxed()
                .map(this::company);
    }

    private Stream<Day> days(int i) {
        return range(0, i)
                .boxed()
                .map(this::day);
    }

    private CompanyName company(Integer s) {
        return new CompanyName(s.toString());
    }


    private CompanyName firstCompany() {
        return new CompanyName("dummy");
    }

    private void store(CompanyName companyName, PricePerDay price) {
        service.store(companyName,price);
    }

    private PricePerDay price(Day day, StockPrice stockPrice) {
        return new PricePerDay(day, stockPrice);
    }

    StockPricesPerDay findStocksBy(Day day) {
        return repository.findById(day)
                .orElseThrow(RuntimeException::new);
    }

    Day firstDay() {
        return Day.createFrom("first");
    }

    Day day(Integer day) {
        return Day.createFrom(day.toString());
    }

    StockPrice stockPrice(){
        return new StockPrice(0D,0D,0D,0D, 0L);
    }
}
