package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.Ask;
import com.mitchmele.optionslounge.option.repository.mongo.AskDORepository;
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
class AskServiceTest {


    @Mock
    private AskDORepository askDORepository;

    @InjectMocks
    private AskService service;

    @Test
    void getBids_returnsAllLiveBidsInMarket() {

        Date mockDate = mock(Date.class);

        Ask ask = Ask.builder()
                .askPrice(BigDecimal.valueOf(20.01))
                .id(1)
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        Ask ask2 = Ask.builder()
                .askPrice(BigDecimal.valueOf(120.21))
                .id(2)
                .symbol("AAPL")
                .timeStamp(mockDate)
                .build();

        List<Ask> expected = asList(ask, ask2);
        when(askDORepository.findAll()).thenReturn(expected);

        List<Ask> actual = service.getAsks();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getAllAsksBySymbol_returnsAllAskForProvidedSymbol() {

        Date mockDate = mock(Date.class);

        Ask ask = Ask.builder()
                .askPrice(BigDecimal.valueOf(20.01))
                .id(1)
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        Ask ask2 = Ask.builder()
                .askPrice(BigDecimal.valueOf(20.21))
                .id(2)
                .symbol("ABC")
                .timeStamp(mockDate)
                .build();

        List<Ask> expected = asList(ask, ask2);
        when(askDORepository.findAllBySymbol(anyString())).thenReturn(expected);

        List<Ask> actual = service.getAllAsksBySymbol("ABC");

        assertThat(actual).isEqualTo(expected);
    }
}