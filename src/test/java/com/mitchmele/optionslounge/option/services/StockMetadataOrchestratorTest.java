package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.*;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockMetadataOrchestratorTest {

    @Mock
    private AskService askService;

    @Mock
    private BidService bidService;

    @Mock
    private StockMetadataService stockMetadataService;

    @InjectMocks
    private StockMetadataOrchestrator stockMetadataOrchestrator;

    @Test
    void getAllQuotes_returnsListOfQuotePrices() {

        Date mockDate = mock(Date.class);

        Bid bid = Bid.builder()
                .bidPrice(BigDecimal.valueOf(20.01))
                .id("1")
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        Ask ask = Ask.builder()
                .askPrice(BigDecimal.valueOf(20.10))
                .id("2")
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        when(bidService.getBids()).thenReturn(asList(bid));
        when(askService.getAsks()).thenReturn(asList(ask));

        List<QuotePrice> actual = stockMetadataOrchestrator.getLiveQuotes();

        assertThat(actual).isEqualTo(asList(bid, ask));
    }

    @Test
    void getStockDetails_callsQuoteServicesToGetPrices_callsDetailsServiceToGetMetadata() {

        Date mockDate = mock(Date.class);

        Bid bid = Bid.builder()
                .bidPrice(BigDecimal.valueOf(20.01))
                .id("1")
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();


        Bid bid2 = Bid.builder()
                .bidPrice(BigDecimal.valueOf(20.10))
                .id("2")
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        Ask ask = Ask.builder()
                .askPrice(BigDecimal.valueOf(20.20))
                .id("2")
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        Ask ask2 = Ask.builder()
                .askPrice(BigDecimal.valueOf(20.13))
                .id("2")
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        when(bidService.getAllBidsBySymbol(anyString())).thenReturn(asList(bid, bid2));
        when(askService.getAllAsksBySymbol(anyString())).thenReturn(asList(ask, ask2));

        StockMetadata expectedMetadata = StockMetadata.builder()
                .ticker("ABC")
                .sector("Financial")
                .industry("Exchange Traded Fund")
                .company("Mellon Focused Growth ADR ETF")
                .averageVolume(10.07)
                .build();

        when(stockMetadataService.getMetadata(anyString())).thenReturn(expectedMetadata);

        LiveQuote expectedLiveQuote = LiveQuote.builder()
                .symbol("ABC")
                .bid(BigDecimal.valueOf(20.10))
                .ask(BigDecimal.valueOf(20.13))
                .build();

        StockDetailsResponse expected = StockDetailsResponse.builder()
                .liveQuote(expectedLiveQuote)
                .stockMetadata(expectedMetadata)
                .build();

        StockDetailsResponse actual = stockMetadataOrchestrator.getStockDetails("ABC");

        assertThat(actual).isEqualTo(expected);

        verify(bidService).getAllBidsBySymbol("ABC");
        verify(askService).getAllAsksBySymbol("ABC");
        verify(stockMetadataService).getMetadata("ABC");
    }
}