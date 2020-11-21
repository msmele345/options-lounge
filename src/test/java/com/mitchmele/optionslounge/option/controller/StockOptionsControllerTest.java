package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.StockOption;
import com.mitchmele.optionslounge.option.services.OptionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class StockOptionsControllerTest {

    @Mock
    private OptionsService optionsService;

    @InjectMocks
    private StockOptionsController stockOptionsController;

    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(stockOptionsController).build();
    }

    @Test
    void getAllOptions_returnsAllOptionsCurrentlyOpenInDb() throws Exception {

        StockOption abcCall = StockOption.builder().symbol("ABC").strikePrice(22.0).month("JULY").type("CALL").build();
        StockOption abcPut = StockOption.builder().symbol("ABC").strikePrice(25.0).month("DEC").type("PAT").build();

        List<StockOption> expected = asList(abcCall, abcPut);
        when(optionsService.fetchAllOptions())
                .thenReturn(expected);

        mockMvc
                .perform(get("/options"))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(expected)));
    }

    @Test
    void getOptionsByType_returnsAllOptionsOfProvidedType() throws Exception {

        StockOption abcPut1 = StockOption.builder().symbol("PUT").strikePrice(22.0).month("JULY").type("CALL").build();
        StockOption abcPut2 = StockOption.builder().symbol("PUT").strikePrice(25.0).month("DEC").type("PAT").build();


        List<StockOption> puts = asList(abcPut1, abcPut2);
        when(optionsService.fetchAllOptionsByType(anyString()))
                .thenReturn(puts);

        mockMvc
                .perform(get("/options/stocks?type=PUT"))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(puts)));

    }
}