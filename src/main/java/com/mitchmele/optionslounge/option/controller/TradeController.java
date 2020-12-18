package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.Trade;
import com.mitchmele.optionslounge.option.services.TradesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TradeController {

    private final TradesService tradingService;

    @GetMapping("/trades")
    @CrossOrigin
    public List<Trade> getTrades() throws IOException {
        return tradingService.fetchAllTrades();
    }

    @GetMapping("/trades/{symbol}")
    @CrossOrigin
    public List<Trade> getTradesBySymbol(@PathVariable String symbol) throws IOException {
        return tradingService.fetchTradesForSymbol(symbol.toUpperCase());
    }
}
