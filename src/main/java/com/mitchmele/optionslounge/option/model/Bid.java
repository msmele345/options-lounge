package com.mitchmele.optionslounge.option.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Bid")
public class Bid implements QuotePrice, Serializable {

    @Id
    private Integer id;

    private String symbol;

    private BigDecimal bidPrice;

    @CreationTimestamp
    private Date timeStamp;

    @Override
    public BigDecimal getPrice() {
        return bidPrice;
    }
}
