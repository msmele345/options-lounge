package com.mitchmele.optionslounge.option.repository;

import com.mitchmele.optionslounge.option.model.StockOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<StockOption, Integer> {

    List<StockOption> findAllByType(String type);

    List<StockOption> findAllBySymbol(String symbol);
}
