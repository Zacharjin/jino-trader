package org.jinoware.trader.loader.common.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class Day {

    public static Day createFrom(String day){
        return new Day(day);
    }

    String date;

}
