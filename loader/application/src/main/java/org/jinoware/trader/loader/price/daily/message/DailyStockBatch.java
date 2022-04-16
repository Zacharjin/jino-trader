package org.jinoware.trader.loader.price.daily.message;

import lombok.Data;

import java.util.List;

@Data
public class DailyStockBatch {
    String companyName;
    List<DailyStockPrice> data;
}
