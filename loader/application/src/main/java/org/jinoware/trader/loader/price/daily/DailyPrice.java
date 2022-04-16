package org.jinoware.trader.loader.price.daily;

import lombok.Value;

import java.util.Date;

@Value
public class DailyPrice {
    Date day;
    Double open;
    Double high;
    Double low;
    Double close;
    Long volume;
}
