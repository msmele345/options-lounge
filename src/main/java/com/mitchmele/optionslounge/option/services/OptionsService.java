package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.exception.InvalidOptionTypeException;
import com.mitchmele.optionslounge.option.model.OptionsRequest;
import com.mitchmele.optionslounge.option.model.StockOption;
import com.mitchmele.optionslounge.option.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.Arrays.asList;
import static org.apache.logging.log4j.util.Strings.isEmpty;

@Service
@RequiredArgsConstructor
public class OptionsService {

    private final OptionRepository optionRepository;
    private static final List<String> acceptableTypes = asList("PUT", "CALL");

    public List<StockOption> fetchAllOptions(String type) {

        if (type == null) {
            return optionRepository.findAll();
        }

        if (!acceptableTypes.contains(type)) {
            throw new InvalidOptionTypeException("Please Enter a Valid Options Type");
        }

        return optionRepository.findAllByType(type.toUpperCase());
    }

    public List<StockOption> fetchAllOptionsForSymbol(String symbol) {
        return optionRepository.findAllBySymbol(symbol);
    }

    public List<StockOption> fetchOptions(OptionsRequest request) {

        if(isEmpty(request.getSymbol()) && isEmpty(request.getType())) {
            return optionRepository.findAll();
        }

        if (isEmpty(request.getSymbol())) {
            return optionRepository.findAllByType(request.getType());
        }

        if(isEmpty(request.getType())) {
            return optionRepository.findAllBySymbol(request.getSymbol());
        }

        return optionRepository.findAllByTypeAndSymbol(request.getType(), request.getSymbol());
    }
}
