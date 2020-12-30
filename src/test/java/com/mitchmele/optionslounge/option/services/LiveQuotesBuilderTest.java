package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.Ask;
import com.mitchmele.optionslounge.option.model.Bid;
import com.mitchmele.optionslounge.option.model.LiveQuote;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class LiveQuotesBuilderTest {

    @InjectMocks
    private LiveQuotesBuilder builder;

    @Test
    @Disabled("TODO with getQuotesForSymbol")
    void buildLiveQuotes_takesListsOfBidsAndAsksAndCreatesQuotesForEachSymbol() {

        Date mockDate = mock(Date.class);

        Bid bid = Bid.builder()
                .bidPrice(BigDecimal.valueOf(20.01))
                .id(1)
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        Ask ask = Ask.builder()
                .askPrice(BigDecimal.valueOf(20.10))
                .id(2)
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        Bid bid2 = Bid.builder()
                .bidPrice(BigDecimal.valueOf(5.01))
                .id(3)
                .symbol("DDY")
                .timeStamp(mockDate)
                .build();

        Ask ask2 = Ask.builder()
                .askPrice(BigDecimal.valueOf(5.10))
                .id(4)
                .symbol("DDY")
                .timeStamp(mockDate)
                .build();

        LiveQuote expected1 = LiveQuote.builder()
                .symbol("ABC")
                .bid(BigDecimal.valueOf(20.01))
                .ask(BigDecimal.valueOf(20.10))
                .build();

        LiveQuote expected2 = LiveQuote.builder()
                .symbol("DDY")
                .bid(BigDecimal.valueOf(5.01))
                .ask(BigDecimal.valueOf(5.10))
                .build();

        List<LiveQuote> expected = asList(expected1, expected2);

        List<LiveQuote> actual = builder.buildLiveQuotes(asList(bid, bid2, ask, ask2));

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}