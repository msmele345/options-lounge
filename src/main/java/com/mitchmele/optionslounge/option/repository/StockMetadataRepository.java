package com.mitchmele.optionslounge.option.repository;

import com.mitchmele.optionslounge.option.model.StockMetadata;
import com.mitchmele.optionslounge.option.model.Trade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMetadataRepository extends MongoRepository<StockMetadata, String> {

    StockMetadata findByTicker(String ticker);
}
