package org.jinoware.trader.loader;

import org.jinoware.trader.loader.company.Company;
import org.jinoware.trader.loader.company.CompanyRepository;
import org.jinoware.trader.loader.price.daily.DailyStockFetchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@ComponentScan(basePackages = {"org.jinoware"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
