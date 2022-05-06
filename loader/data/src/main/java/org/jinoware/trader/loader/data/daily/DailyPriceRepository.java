package org.jinoware.trader.loader.data.daily;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface DailyPriceRepository extends MongoRepository<StockPricesPerDay, Date> {

}
