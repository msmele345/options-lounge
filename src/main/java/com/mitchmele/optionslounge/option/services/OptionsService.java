package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.StockOption;
import com.mitchmele.optionslounge.option.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionsService {

    private final OptionRepository optionRepository;

    public List<StockOption> fetchAllOptions(String type) {

        if (type == null) {
            return optionRepository.findAll();
        }
        return optionRepository.findAllByType(type.toUpperCase());
    }

    public List<StockOption> fetchAllOptionsForSymbol(String symbol) {
        return optionRepository.findAllBySymbol(symbol);
    }
}
