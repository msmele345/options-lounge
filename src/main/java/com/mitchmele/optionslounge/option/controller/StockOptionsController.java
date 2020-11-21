package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.StockOption;
import com.mitchmele.optionslounge.option.services.OptionsService;
import lombok.NonNull;
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
    public List<StockOption> getAllOptions() {
        return optionsService.fetchAllOptions();
    }

    @GetMapping("/options/stocks")
    public List<StockOption> getOptionsByType(@RequestParam @NonNull String type) {
        return optionsService.fetchAllOptionsByType(type);
    }
}
//http://localhost:8080/options/types? fix url
//add error handling around input of TYPE (uppercase every request?)
//add rest advice
//add query by stock endpoint
//create transformers
//add gradle build to dockerfile
//add IT test config
//fix IT tests