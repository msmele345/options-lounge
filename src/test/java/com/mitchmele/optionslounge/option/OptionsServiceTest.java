package com.mitchmele.optionslounge.option;

import com.mitchmele.optionslounge.option.exception.InvalidOptionTypeException;
import com.mitchmele.optionslounge.option.model.StockOption;
import com.mitchmele.optionslounge.option.repository.OptionRepository;
import com.mitchmele.optionslounge.option.services.OptionsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OptionsServiceTest {

    @Mock
    private OptionRepository optionRepository;

    @InjectMocks
    private OptionsService optionsService;

    @Test
    void fetchAllOptions_callsFindAll_whenNoArgProvided_returnsAllInDb() {

        when(optionRepository.findAll())
                .thenReturn(singletonList(StockOption.builder().build()));

        optionsService.fetchAllOptions(null);

        verify(optionRepository).findAll();
    }

    @Test
    void fetchAllOptions_callsFindByType_whenTypeIsProvided_returnsAllInDb() {

        StockOption abcPut1 = StockOption.builder().symbol("ABC").strikePrice(22.0).month("JULY").type("PUT").build();


        when(optionRepository.findAllByType(anyString()))
                .thenReturn(singletonList(abcPut1));

        optionsService.fetchAllOptions("PUT");

        verify(optionRepository).findAllByType("PUT");
    }

    @Test
    void fetchAllOptions_returnsAllOptionsFromRepoOfSpecificType() {
        StockOption abcPut1 = StockOption.builder().symbol("ABC").strikePrice(22.0).month("JULY").type("PUT").build();
        StockOption dycPut2 = StockOption.builder().symbol("DYC").strikePrice(25.0).month("DEC").type("PUT").build();

        List<StockOption> expected = asList(abcPut1, dycPut2);
        when(optionRepository.findAllByType(anyString()))
                .thenReturn(expected);

        List<StockOption> actual = optionsService.fetchAllOptions("PUT");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void fetchAllOptionsForSymbol_returnsAllOptionsForProvidedSymbol() {
        StockOption mmnPut = StockOption.builder().symbol("MMN").strikePrice(22.0).month("JULY").type("PUT").build();
        StockOption mmnCall = StockOption.builder().symbol("MMN").strikePrice(25.0).month("SEPT").type("CALL").build();

        List<StockOption> expected = asList(mmnPut, mmnCall);
        when(optionRepository.findAllBySymbol(anyString()))
                .thenReturn(expected);

        List<StockOption> actual = optionsService.fetchAllOptionsForSymbol("MMN");
        assertThat(actual).isEqualTo(expected);

        verify(optionRepository).findAllBySymbol("MMN");
    }

    @Test
    void fetchAllOptions_throwsInvalidOptionsTypeException_ifProvidedTypeIsNotCallOrPut() {

        assertThatThrownBy(() -> optionsService.fetchAllOptions("sdfds"))
                .isInstanceOf(InvalidOptionTypeException.class)
                .hasMessage("Please Enter a Valid Options Type");
    }
}