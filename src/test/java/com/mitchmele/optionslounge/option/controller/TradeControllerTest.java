package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.Trade;
import com.mitchmele.optionslounge.option.services.TradesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class TradeControllerTest {

    @Mock
    private TradesService tradesService;

    @InjectMocks
    private TradeController tradeController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(tradeController).build();
    }

    private final Date timeOfTrade = mock(Date.class);

    @Test
    public void getTrades_success_shouldReturn200AndCallService() throws Exception {

        mockMvc.perform(
                get("/api/v1/trades/")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().is2xxSuccessful());

        verify(tradesService).fetchAllTrades();
    }


    @Test
    public void getTrades_success_shouldReturn200AndAllTradesFromService() throws Exception {

        Trade trade1 = new Trade(1, "ABC", 50.00, timeOfTrade, "NASDAQ");
        Trade trade2 = new Trade(2, "ABC", 51.00, timeOfTrade, "NASDAQ");
        Trade trade3 = new Trade(3, "ABC", 52.00, timeOfTrade, "NASDAQ");

        List<Trade> trades = asList(trade1, trade2, trade3);

        when(tradesService.fetchAllTrades()).thenReturn(trades);

        mockMvc.perform(
                get("/api/v1/trades/")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        verify(tradesService).fetchAllTrades();
    }
}