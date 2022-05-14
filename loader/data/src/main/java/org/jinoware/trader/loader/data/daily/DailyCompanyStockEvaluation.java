package org.jinoware.trader.loader.data.daily;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jinoware.trader.loader.common.model.CompanyName;
import org.jinoware.trader.loader.common.model.StockPrice;
import org.jinoware.trader.loader.data.model.IdentifiableByCompanyName;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyCompanyStockEvaluation implements IdentifiableByCompanyName {
    CompanyName companyName;

    StockPrice price;

}
