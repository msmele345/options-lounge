package com.mitchmele.optionslounge.option.model;

import java.math.BigDecimal;

public interface QuotePrice {
    String getSymbol();
    BigDecimal getPrice();
}
