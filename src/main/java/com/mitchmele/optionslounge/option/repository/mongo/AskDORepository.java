package com.mitchmele.optionslounge.option.repository.mongo;

import com.mitchmele.optionslounge.option.model.Ask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskDORepository extends MongoRepository<Ask, String > {

    List<Ask> findAllBySymbol(String symbol);
}
