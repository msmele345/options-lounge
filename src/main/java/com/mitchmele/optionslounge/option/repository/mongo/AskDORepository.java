package com.mitchmele.optionslounge.option.repository.mongo;

import com.mitchmele.optionslounge.option.model.Ask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AskDORepository extends MongoRepository<Ask, String > {
}
