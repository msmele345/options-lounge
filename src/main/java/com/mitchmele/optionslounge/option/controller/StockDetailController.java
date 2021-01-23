package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.QuotePrice;
import com.mitchmele.optionslounge.option.model.StockDetailsResponse;
import com.mitchmele.optionslounge.option.services.StockMetadataOrchestrator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StockDetailController {

    private final StockMetadataOrchestrator stockMetadataOrchestrator;

    @GetMapping("/quotes")
    @CrossOrigin
    public List<QuotePrice> getStockDetails() {
        return stockMetadataOrchestrator.getLiveQuotes();
    }

    @GetMapping("/stocks")
    @CrossOrigin
    public StockDetailsResponse getStockDetails(@RequestParam String symbol) {
        return stockMetadataOrchestrator.getStockDetails(symbol.toUpperCase());
    }
}
