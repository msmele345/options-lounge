package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.StockOption;
import com.mitchmele.optionslounge.option.services.OptionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StockOptionsController {

    private final OptionsService optionsService;

    @GetMapping("/options")
    public List<StockOption> getAllOptions(@RequestParam(required = false) String type) {
        return optionsService.fetchAllOptions(type);
    }

    @GetMapping("/options/stocks")
    public List<StockOption> getOptionsBySymbol(@RequestParam String symbol) {
        return optionsService.fetchAllOptionsForSymbol(symbol);
    }
}
//test containers IT test with mysql
//add rest advice
//add query by stock endpointx
//create transformers (dates)
//add gradle build to dockerfile
//add IT test config
