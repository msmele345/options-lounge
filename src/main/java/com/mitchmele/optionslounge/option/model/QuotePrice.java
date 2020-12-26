package com.mitchmele.optionslounge.option.model;

import java.math.BigDecimal;

public interface QuotePrice {
    Integer getId();
    String getSymbol();
    BigDecimal getPrice();
}
