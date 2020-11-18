package com.mitchmele.optionslounge.option;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String symbol;
    private String type;
    private String month;

    @Column(name = "Currentprice")
    private double currentPrice;

    @Column(name = "Strikeprice")
    private double strikePrice;

    @Column(name = "Expirationdate")
    private Date expirationDate;

    @CreationTimestamp
    @Column(name = "CREATED_TS", updatable = false)
    private Date createdAt;
}

