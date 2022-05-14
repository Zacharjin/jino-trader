package org.jinoware.trader.loader.common.model;

import lombok.Value;

import java.util.Date;

@Value
public class PricePerDay {
    Day day;
    StockPrice price;
}
