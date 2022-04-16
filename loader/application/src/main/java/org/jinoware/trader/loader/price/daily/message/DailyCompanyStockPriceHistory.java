package org.jinoware.trader.loader.price.daily.message;

import lombok.Value;
import org.jinoware.trader.loader.price.daily.DailyPrice;

import java.util.List;

@Value
public class DailyCompanyStockPriceHistory {
    String companyName;
    List<DailyPrice> data;
}
