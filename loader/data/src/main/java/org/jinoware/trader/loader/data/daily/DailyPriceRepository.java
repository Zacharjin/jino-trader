package org.jinoware.trader.loader.data.daily;

import org.jinoware.trader.loader.common.model.Day;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DailyPriceRepository extends MongoRepository<StockPricesPerDay, Day> {

}
