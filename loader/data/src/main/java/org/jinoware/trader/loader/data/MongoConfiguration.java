package org.jinoware.trader.loader.data;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "org.jinoware.trader.loader.data")
public class MongoConfiguration {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.database}")
    String database;

    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString(String.join("/", Arrays.asList(url ,database)));
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), database);
    }
}