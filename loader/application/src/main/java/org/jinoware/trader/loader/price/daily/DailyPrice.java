package org.jinoware.trader.loader.price.daily;

import lombok.Value;
import org.jinoware.trader.loader.common.model.Day;
import org.jinoware.trader.loader.common.model.StockPrice;

import java.util.Date;

@Value
public class DailyPrice {
    Day day;
    StockPrice price;
}
