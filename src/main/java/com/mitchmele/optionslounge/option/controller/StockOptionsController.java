package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.StockOption;
import com.mitchmele.optionslounge.option.services.OptionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StockOptionsController {

    private final OptionsService optionsService;

    @GetMapping("/options")
    @CrossOrigin
    public List<StockOption> getAllOptions(@RequestParam(required = false) String type) {
        return optionsService.fetchAllOptions(type);
    }

    //symbol and type endpoint? NEXT
    //create transformers (dates)

    @GetMapping("/options/stocks")
    public List<StockOption> getOptionsBySymbol(@RequestParam String symbol) {
        return optionsService.fetchAllOptionsForSymbol(symbol);
    }
}
