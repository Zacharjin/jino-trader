package org.jinoware.trader.loader.data.temporal;

import lombok.Value;
import org.jinoware.trader.loader.price.StockPrice;

import java.util.Date;

@Value
public class StockTick {

    Date time;

    StockPrice price;

}
