package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.services.QuoteDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debug")
@RequiredArgsConstructor
public class DebugController {

    private final QuoteDataService quoteDataService;

    @GetMapping("/seed")
    public void mapBidsAndOffers() {
        quoteDataService.generateData();
    }
}
