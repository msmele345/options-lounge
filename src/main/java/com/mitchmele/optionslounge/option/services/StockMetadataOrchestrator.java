package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StockMetadataOrchestrator {

    private final AskService askService;
    private final BidService bidService;
    private final StockMetadataService stockMetadataService;

    public List<QuotePrice> getLiveQuotes() {

        return Stream.concat(bidService.getBids().stream(), askService.getAsks().stream())
                .collect(Collectors.toList());
    }

    public StockDetailsResponse getStockDetails(String symbol) {

        BigDecimal highestBid = bidService.getAllBidsBySymbol(symbol).stream()
                .map(Bid::getBidPrice)
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);


        BigDecimal lowestOffer = askService.getAllAsksBySymbol(symbol).stream()
                .map(Ask::getAskPrice)
                .min(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);

        StockMetadata stockMetadata = stockMetadataService.getMetadata(symbol);

        return StockDetailsResponse.builder()
                .liveQuote(LiveQuote.builder().symbol(symbol).bid(highestBid).ask(lowestOffer).build())
                .stockMetadata(stockMetadata)
                .build();
    }
}
