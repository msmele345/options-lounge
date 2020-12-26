package com.mitchmele.optionslounge.option.repository.mongo;

import com.mitchmele.optionslounge.option.model.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidDORepository extends MongoRepository<Bid, String > {
}
