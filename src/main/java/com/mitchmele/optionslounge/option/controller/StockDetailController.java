package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.QuotePrice;
import com.mitchmele.optionslounge.option.model.StockDetailsResponse;
import com.mitchmele.optionslounge.option.services.QuoteDataService;
import com.mitchmele.optionslounge.option.services.StockDetailsOrchestrator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StockDetailController {

    private final StockDetailsOrchestrator stockDetailsOrchestrator;

    @GetMapping("/quotes")
    @CrossOrigin
    public List<QuotePrice> getStockDetails() {
        return stockDetailsOrchestrator.getLiveQuotes();
    }

    @GetMapping("/stocks")
    @CrossOrigin
    public StockDetailsResponse getStockDetails(@RequestParam String symbol) {
        return stockDetailsOrchestrator.getStockDetails(symbol.toUpperCase());
    }
}
