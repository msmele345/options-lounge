package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.Ask;
import com.mitchmele.optionslounge.option.model.Bid;
import com.mitchmele.optionslounge.option.model.LiveQuote;
import com.mitchmele.optionslounge.option.model.QuotePrice;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LiveQuotesOrchestratorTest {

    @Mock
    private AskService askService;

    @Mock
    private BidService bidService;

    @InjectMocks
    private LiveQuotesOrchestrator liveQuotesOrchestrator;

    @Test
    void getAllQuotes_returnsListOfQuotePrices() {

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

        when(bidService.getBids()).thenReturn(asList(bid));
        when(askService.getAsks()).thenReturn(asList(ask));

        List<QuotePrice> actual = liveQuotesOrchestrator.getLiveQuotes();

        assertThat(actual).isEqualTo(asList(bid, ask));
    }

    @Test
    @Disabled("TODO")
    void getQuotes_returnsListOfLiveQuoteObjects() {

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

        when(bidService.getBids()).thenReturn(asList(bid));
        when(askService.getAsks()).thenReturn(asList(ask));

        LiveQuote expected = LiveQuote.builder()
                .bid(bid)
                .ask(ask)
                .build();

        List<LiveQuote> actual = liveQuotesOrchestrator.getQuoteForSymbol();

        assertThat(actual).isEqualTo(expected);
    }
}