package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.QuotePrice;
import com.mitchmele.optionslounge.option.model.Trade;
import com.mitchmele.optionslounge.option.services.LiveQuotesOrchestrator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class QuotesController {

    private final LiveQuotesOrchestrator liveQuotesOrchestrator;

    @GetMapping("/quotes")
    @CrossOrigin
    public List<QuotePrice> getAllQuotes() {
        return liveQuotesOrchestrator.getLiveQuotes();
    }
}
