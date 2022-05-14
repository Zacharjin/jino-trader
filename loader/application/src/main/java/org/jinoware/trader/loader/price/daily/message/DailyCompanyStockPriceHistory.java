package org.jinoware.trader.loader.price.daily.message;

import lombok.Value;
import org.jinoware.trader.loader.common.model.CompanyName;
import org.jinoware.trader.loader.price.daily.DailyPrice;

import java.util.List;

@Value
public class DailyCompanyStockPriceHistory {
    CompanyName companyName;
    List<DailyPrice> data;
}
