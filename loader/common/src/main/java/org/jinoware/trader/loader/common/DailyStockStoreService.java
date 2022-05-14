package org.jinoware.trader.loader.common;

import org.jinoware.trader.loader.common.model.CompanyName;
import org.jinoware.trader.loader.common.model.PricePerDay;

public interface DailyStockStoreService {

    void store(CompanyName name, PricePerDay data);
}
