package org.jinoware.trader.loader.price.daily.message;

import lombok.Value;

import java.util.Date;

@Value
public class DailyStockPrice {
    Date day;
    Double open;
    Double high;
    Double low;
    Double close;
    Long volume;
}
