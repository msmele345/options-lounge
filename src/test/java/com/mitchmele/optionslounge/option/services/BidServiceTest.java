package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.Bid;
import com.mitchmele.optionslounge.option.repository.mongo.BidDORepository;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BidServiceTest {

    @Mock
    private BidDORepository bidDORepository;

    @InjectMocks
    private BidService service;


    @Test
    void getBids_returnsAllLiveBidsInMarket() {

        Date mockDate = mock(Date.class);

        Bid bid = Bid.builder()
                .bidPrice(BigDecimal.valueOf(20.01))
                .id("1")
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        Bid bid2 = Bid.builder()
                .bidPrice(BigDecimal.valueOf(120.21))
                .id("2")
                .symbol("AAPL")
                .timeStamp(mockDate)
                .build();


        List<Bid> expected = asList(bid, bid2);
        when(bidDORepository.findAll()).thenReturn(expected);

        List<Bid> actual = service.getBids();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getBidsBySymbol_onlyReturnsBidsForProvidedSymbol() {

        Date mockDate = mock(Date.class);

        Bid bid = Bid.builder()
                .bidPrice(BigDecimal.valueOf(20.01))
                .id("1")
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        Bid bid2 = Bid.builder()
                .bidPrice(BigDecimal.valueOf(20.22))
                .id("2")
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();


        List<Bid> expected = asList(bid, bid2);
        when(bidDORepository.findAllBySymbol(anyString())).thenReturn(expected);

        List<Bid> actual = service.getAllBidsBySymbol("ABC");

        assertThat(actual).isEqualTo(expected);
    }
}