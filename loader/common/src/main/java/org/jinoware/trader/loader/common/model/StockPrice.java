package org.jinoware.trader.loader.common.model;

import lombok.Value;

@Value
public class StockPrice {

    public static StockPrice createEmpty() {
        return new StockPrice(0D,0D, 0D,0D, 0L);
    }

    Double open;
    Double high;
    Double low;
    Double close;
    Long volume;

}
