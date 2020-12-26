package com.mitchmele.optionslounge.option.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LiveQuote {

    private Bid bid;
    private Ask ask;
    private String symbol;

    @CreationTimestamp
    private Date createdAt;

}
