package com.mitchmele.optionslounge.option.repository.mongo;

import com.mitchmele.optionslounge.option.model.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidDORepository extends MongoRepository<Bid, String > {

    List<Bid> findAllBySymbol(String symbol);
    List<Bid> findAllBySymbolOrderByBidPriceDesc(String symbol);
}
