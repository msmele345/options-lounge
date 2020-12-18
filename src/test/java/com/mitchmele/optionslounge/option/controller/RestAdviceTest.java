package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.exception.InvalidOptionTypeException;
import com.mitchmele.optionslounge.option.model.ErrorResponse;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class RestAdviceTest {

    @Mock
    private OptionsService optionsService;

    @InjectMocks
    private StockOptionsController stockOptionsController;

    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(stockOptionsController)
                .setControllerAdvice(new RestAdvice())
                .build();
    }

    @Test
    void handleGetAllOptions_returns500IfExceptionsAreThrown() throws Exception {

        RuntimeException exception = new RuntimeException("something bad happened");
        when(optionsService.fetchAllOptions(any()))
                .thenThrow(exception);

        ErrorResponse expected = ErrorResponse.builder()
                .message("something bad happened")
                .exception(exception.getClass().toString())
                .build();

        mockMvc
                .perform(get("/options"))
                .andExpect(status().is5xxServerError())
                .andExpect(content().string(mapper.writeValueAsString(expected)));

    }

    @Test
    void handleGetAllOptions_returns403IfTypeIsProvidedButNotValid() throws Exception {

        RuntimeException exception = new InvalidOptionTypeException("Please Enter a Valid Options Type");
        when(optionsService.fetchAllOptions(any()))
                .thenThrow(exception);

        ErrorResponse expected = ErrorResponse.builder()
                .message("Please Enter a Valid Options Type")
                .exception(exception.getClass().toString())
                .build();

        mockMvc
                .perform(get("/options?type=BB"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(mapper.writeValueAsString(expected)));

    }
}
