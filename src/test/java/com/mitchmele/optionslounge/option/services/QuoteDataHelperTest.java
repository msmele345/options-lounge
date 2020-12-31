package com.mitchmele.optionslounge.option.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class QuoteDataHelperTest {

    @InjectMocks
    private QuoteDataHelper quoteDataHelper;

    @Test
    void nextBid() {

        BigDecimal actual = quoteDataHelper.nextBid(.05);

        assertThat(actual).isNotNegative();
    }

    @Test
    void nextAsk() {

        BigDecimal actual = quoteDataHelper.nextAsk(.10);

        assertThat(actual).isNotNegative();
    }
}