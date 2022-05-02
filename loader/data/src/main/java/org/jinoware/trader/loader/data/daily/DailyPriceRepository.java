package org.jinoware.trader.loader.data.daily;

import org.jinoware.trader.loader.data.StockPricesPerDay;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface DailyPriceRepository extends MongoRepository<StockPricesPerDay, Date> {

}
