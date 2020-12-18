package com.mitchmele.optionslounge.option.repository;

import com.mitchmele.optionslounge.option.model.Trade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends MongoRepository<Trade, String> {

    List<Trade> findAllBySymbol(String symbol);
}
