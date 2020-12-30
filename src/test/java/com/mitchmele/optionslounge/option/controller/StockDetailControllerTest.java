package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.Ask;
import com.mitchmele.optionslounge.option.model.Bid;
import com.mitchmele.optionslounge.option.model.QuotePrice;
import com.mitchmele.optionslounge.option.services.StockDetailsOrchestrator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class StockDetailControllerTest {

    @Mock
    private StockDetailsOrchestrator stockDetailsOrchestrator;

    @InjectMocks
    private StockDetailController stockDetailController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(stockDetailController).build();
    }

    @Test
    void getAllQuotes() throws Exception {

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

        List<QuotePrice> expected = asList(bid, ask);
        when(stockDetailsOrchestrator.getLiveQuotes())
                .thenReturn(expected);


        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(get("/api/v1/quotes"))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(expected)));
    }
}