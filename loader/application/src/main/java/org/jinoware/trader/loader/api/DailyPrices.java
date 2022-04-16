package org.jinoware.trader.loader.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class DailyPrices {

    @JsonAlias("Time Series (Daily)")
    Map<Date, DailyValuation> details;
}
