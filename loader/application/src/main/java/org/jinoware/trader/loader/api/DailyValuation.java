package org.jinoware.trader.loader.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class DailyValuation {
    @JsonAlias("1. open")
    Double open;
    @JsonAlias("2. high")
    Double high;
    @JsonAlias("3. low")
    Double low;
    @JsonAlias("4. close")
    Double close;
    @JsonAlias("5. volume")
    Long volume;
}
