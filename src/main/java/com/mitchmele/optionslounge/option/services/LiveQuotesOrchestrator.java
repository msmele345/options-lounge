package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.LiveQuote;
import com.mitchmele.optionslounge.option.model.QuotePrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class LiveQuotesOrchestrator {

    private final AskService askService;
    private final BidService bidService;
    private final LiveQuotesBuilder liveQuotesBuilder;

    public List<QuotePrice> getLiveQuotes() {

        return Stream.concat(bidService.getBids().stream(), askService.getAsks().stream())
                .collect(Collectors.toList());
    }

    //TODO
    public List<LiveQuote> getQuoteForSymbol() {

        List<QuotePrice> quotes = Stream.concat(bidService.getBids().stream(), askService.getAsks().stream())
                .collect(Collectors.toList());

        Map<String, List<QuotePrice>> mkt = quotes.stream().collect(Collectors.groupingBy(QuotePrice::getSymbol));

        return Collections.emptyList();
    }
}
