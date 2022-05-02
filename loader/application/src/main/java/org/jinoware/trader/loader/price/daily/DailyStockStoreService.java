package org.jinoware.trader.loader.price.daily;

import org.jinoware.trader.loader.api.CompanyName;

import java.util.List;

public interface DailyStockStoreService {

    void store(CompanyName name, DailyPrice data);
}
