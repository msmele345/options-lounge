package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.LiveQuote;
import com.mitchmele.optionslounge.option.model.QuotePrice;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LiveQuotesBuilder {

    public List<LiveQuote> buildLiveQuotes(List<QuotePrice> quotes) {

        Map<String, List<QuotePrice>> mkt = quotes.stream().collect(Collectors.groupingBy(QuotePrice::getSymbol));

//        mkt.entrySet().stream()
//                .map(e -> {
//
//                    int quotesSize = e.getValue().size();
//
//                    LiveQuote.builder()
//                            .symbol(e.getKey())
//                        }
//                )

        return Collections.emptyList();
    }
}
