package com.mitchmele.optionslounge.option;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OptionsServiceTestIT {

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private OptionsService optionsService;


    @AfterEach
    public void reset() {
        optionRepository.deleteAll();
    }


    @BeforeEach
    void setUp() {
        Option abcCall = Option.builder().symbol("ABC").strikePrice(22.0).month("JULY").type("CALL").build();

        optionRepository.save(abcCall);
    }

    @Test
    void doesTheThing() {

        Option expected = Option.builder()
                .id(1L)
                .symbol("ABC")
                .strikePrice(22.0)
                .month("JULY")
                .type("CALL")
                .build();

        List<Option> actual = optionsService.getOptions();

        assertThat(actual.get(0)).isEqualToIgnoringGivenFields(expected, "createdAt");
    }
}