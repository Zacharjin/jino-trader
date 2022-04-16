package org.jinoware.trader.loader.api;

import org.jinoware.trader.loader.stock.StockValue;

import java.util.List;

public interface StockProvider {
    List<StockValue> provide();
}
