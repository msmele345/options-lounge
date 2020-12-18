package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.Trade;
import com.mitchmele.optionslounge.option.repository.TradeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TradesServiceTest {

    @Mock
    private TradeRepository repository;

    @InjectMocks
    private TradesService tradesService;

    private final Date timeOfTrade = mock(Date.class);

    @Test
    void fetchAllTrades_returnsAllTradesInTheMarket() throws IOException {

        Trade trade1 = new Trade(1, "ABC", 50.00, timeOfTrade, "NASDAQ");
        Trade trade2 = new Trade(2, "DDF", 51.00, timeOfTrade, "NASDAQ");
        Trade trade3 = new Trade(3, "WWQ", 52.00, timeOfTrade, "NASDAQ");

        List<Trade> expected = asList(trade1, trade2, trade3);

        when(repository.findAll()).thenReturn(expected);

        List<Trade> actual = tradesService.fetchAllTrades();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void fetchTradesForSymbol_returnsAllTradesForGivenSymbol() throws IOException {

        Trade trade1 = new Trade(1, "ABC", 50.00, timeOfTrade, "NASDAQ");
        Trade trade2 = new Trade(2, "ABC", 51.00, timeOfTrade, "NASDAQ");
        Trade trade3 = new Trade(3, "ABC", 52.00, timeOfTrade, "NASDAQ");

        List<Trade> expected = asList(trade1, trade2, trade3);

        when(repository.findAllBySymbol(anyString())).thenReturn(expected);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        List<Trade> actual = tradesService.fetchTradesForSymbol("ABC");

        assertThat(actual).isEqualTo(expected);

        verify(repository).findAllBySymbol(captor.capture());
        assertThat(captor.getValue()).isEqualTo("ABC");
    }
}