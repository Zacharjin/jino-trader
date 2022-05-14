package org.jinoware.trader.loader.data.daily;

import org.jinoware.trader.loader.common.model.CompanyName;
import org.jinoware.trader.loader.common.model.Day;
import org.jinoware.trader.loader.common.model.PricePerDay;
import org.jinoware.trader.loader.common.model.StockPrice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StockPricesPerDayTest {

    Day day = firstDay();
    StockPricesPerDay stocks = new StockPricesPerDay(day, 0L, new ArrayList<>());

    @Test
    public void testStorage(){
        //given
        CompanyName company = firstCompany();
        //when
        store(company, stockPrice());
        //then
        assertCompaniesSize(1);
    }

    @Test
    public void testStorage_ofMultipleCompanies(){
        //given
        store(firstCompany(), stockPrice());

        //when
        store(secondCompany(), stockPrice());
        //then
        assertCompaniesSize(2);
    }


    @Test
    public void testOnlyOneCompanyPresent_WhenUpdatingMultipleTimes(){
        //given
        CompanyName company = firstCompany();

        store(company, stockPrice());
        //when

        range(0, 10).forEach(
                index ->
                        store(company, stockPrice())
        );

        //then
        assertCompaniesSize(1);
    }



    private CompanyName firstCompany() {
        return new CompanyName("dummy");
    }

    private void store(CompanyName companyName, StockPrice price) {
        stocks.addStockPrice(companyName,price);
    }

    Day firstDay() {
        return Day.createFrom("first");
    }

    CompanyName secondCompany() {
        return new CompanyName("second_company");
    }

    void assertCompaniesSize(int expected) {
        assertEquals(expected, stocks.getPricesPerCompany().size());
    }

    StockPrice stockPrice(){
        return new StockPrice(0D,0D,0D,0D, 0L);
    }
}