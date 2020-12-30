package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.QuotePrice;
import com.mitchmele.optionslounge.option.services.StockDetailsOrchestrator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StockDetailController {

    private final StockDetailsOrchestrator stockDetailsOrchestrator;

    @GetMapping("/quotes")
    @CrossOrigin
    public List<QuotePrice> getAllQuotes() {
        return stockDetailsOrchestrator.getLiveQuotes();
    }
}
