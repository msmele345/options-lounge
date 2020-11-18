package com.mitchmele.optionslounge.option;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
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
    void getAllOptions_returnsAllInDb() {

        when(optionRepository.findAll())
                .thenReturn(singletonList(Option.builder().build()));

        List<Option> actual = optionsService.getOptions();

        assertThat(actual).hasSize(1);

    }
}