package com.mitchmele.optionslounge.option.repository.mongo;

import com.mitchmele.optionslounge.option.repository.TradeRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    private static final String TRADE_REPOSITORY = "tradeRepo";

    @Override
    protected String getDatabaseName() {
        return TRADE_REPOSITORY;
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create();
    }
}
