package org.jinoware.trader.loader.data.repository;

import org.jinoware.trader.loader.common.model.CompanyName;
import org.jinoware.trader.loader.common.model.StockPrice;
import org.jinoware.trader.loader.data.daily.DailyCompanyStockEvaluation;
import org.jinoware.trader.loader.data.model.UpdatePrice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;

class StockPriceRepositoryTest {


    List<DailyCompanyStockEvaluation> members = new ArrayList<>();
    StockPriceRepository<DailyCompanyStockEvaluation> tested = new StockPriceRepository<>(members);
    UpdatePrice<DailyCompanyStockEvaluation> thenUpdate = mock(UpdatePrice.class);

    @Test
    public void testEmptyInsert(){
        //given

        //when
        upsertPriceFor("Jinoware");
        //then
        assertCompanies(1);
    }


    @Test
    public void testNonEmptyInsert(){
        //given
        members.add(new DailyCompanyStockEvaluation(new CompanyName("company_1"), price()));
        //when
        upsertPriceFor("Jinoware");
        //then
        assertCompanies(2);
    }

    @Test
    public void testUpdate(){
        //given
        members.add(new DailyCompanyStockEvaluation(new CompanyName("company_1"), price()));
        members.add(new DailyCompanyStockEvaluation(new CompanyName("company_2"), price()));
        members.add(new DailyCompanyStockEvaluation(new CompanyName("Jinoware"), price()));
        //when
        upsertPriceFor("Jinoware");
        //then
        then(thenUpdate).should()
                .changePrice(any());
    }

    private StockPrice price() {
        return StockPrice.createEmpty();
    }


    private void assertCompanies(int expected) {
        assertEquals(expected, members.size());
    }

    private void upsertPriceFor(String companyName) {
        Supplier<DailyCompanyStockEvaluation> supplier = () -> mock(DailyCompanyStockEvaluation.class);
        tested.insertOrUpdate(new CompanyName(companyName), supplier, thenUpdate );
    }
}