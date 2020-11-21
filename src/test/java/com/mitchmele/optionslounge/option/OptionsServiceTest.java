package com.mitchmele.optionslounge.option;

import com.mitchmele.optionslounge.option.model.StockOption;
import com.mitchmele.optionslounge.option.repository.OptionRepository;
import com.mitchmele.optionslounge.option.services.OptionsService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OptionsServiceTest {

    @Mock
    private OptionRepository optionRepository;

    @InjectMocks
    private OptionsService optionsService;

    @Before
    @After
    public void reset() {
        optionRepository.deleteAll();
    }

    @Test
    void fetchAllOptions_returnsAllInDb() {

        when(optionRepository.findAll())
                .thenReturn(singletonList(StockOption.builder().build()));

        List<StockOption> actual = optionsService.fetchAllOptions();

        assertThat(actual).hasSize(1);
    }

    @Test
    void fetchAllOptions_returnsAllOptionsFromRepoOfSpecificType() {
        StockOption abcPut1 = StockOption.builder().symbol("PUT").strikePrice(22.0).month("JULY").type("CALL").build();
        StockOption abcPut2 = StockOption.builder().symbol("PUT").strikePrice(25.0).month("DEC").type("PAT").build();

        List<StockOption> expected = asList(abcPut1, abcPut2);
        when(optionRepository.findAllByType(anyString()))
                .thenReturn(expected);

        List<StockOption> actual = optionsService.fetchAllOptionsByType("PUT");
        assertThat(actual).isEqualTo(expected);
    }
}