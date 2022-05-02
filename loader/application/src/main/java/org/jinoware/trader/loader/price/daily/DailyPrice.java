package org.jinoware.trader.loader.price.daily;

import lombok.Value;
import org.jinoware.trader.loader.price.StockPrice;

import java.util.Date;

@Value
public class DailyPrice {
    Date day;
    StockPrice price;
}
