package com.mitchmele.optionslounge.option.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tradeRepo")
public class Trade {

    @Id
    private Integer _id;

    private String symbol;
    private Double tradePrice;
    private Date timeStamp;
    private String exchange;


    final static String DEFAULT_EXCHANGE = "NASDAQ";

    public String getExchange() {
        return DEFAULT_EXCHANGE;
    }
}
