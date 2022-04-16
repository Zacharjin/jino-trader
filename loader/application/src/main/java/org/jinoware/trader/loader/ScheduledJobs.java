package org.jinoware.trader.loader;

import org.jinoware.trader.loader.company.Company;
import org.jinoware.trader.loader.company.CompanyRepository;
import org.jinoware.trader.loader.price.daily.DailyStockFetchService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJobs {

    @Scheduled(cron = "30 * * * * *")
    public void scheduleDailyStockPricesFetching(DailyStockFetchService service, CompanyRepository companies){
        companies.findAll().stream()
                .map(Company::getName)
                .forEach(service::fetchDailyStockPrices);
    }
}
