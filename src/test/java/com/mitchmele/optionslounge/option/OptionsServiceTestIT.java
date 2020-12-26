package com.mitchmele.optionslounge.option;

import com.mitchmele.optionslounge.option.model.StockOption;
import com.mitchmele.optionslounge.option.repository.OptionRepository;
import com.mitchmele.optionslounge.option.services.OptionsService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Disabled
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
        StockOption abcCall = StockOption.builder().symbol("ABC").strikePrice(22.0).month("JULY").type("CALL").build();

        optionRepository.save(abcCall);
    }

    @Test
    void doesTheThing() {

        StockOption expected = StockOption.builder()
                .id(1L)
                .symbol("ABC")
                .strikePrice(22.0)
                .month("JULY")
                .type("CALL")
                .build();

//        List<StockOption> actual = optionsService.fetchAllOptions(null);

//        assertThat(actual.get(0)).isEqualToIgnoringGivenFields(expected, "createdAt");
    }
}