package com.mitchmele.optionslounge.option.services;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class QuoteDataHelper {


    public BigDecimal nextBid(double currentBid) {

        Random r = new Random();

        List<Double> nums = Stream.of(.14, .11, .13, .12).collect(Collectors.toList());

        return round(currentBid + nums.get(r.nextInt(nums.size())), 2);
    }

    public BigDecimal nextAsk(double currentAsk) {

        Random r = new Random();

        List<Double> nums = Stream.of(.22, .32, .32, .35).collect(Collectors.toList());

        return round(currentAsk + nums.get(r.nextInt(nums.size())), 2);
    }


    private static BigDecimal round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(String.valueOf(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd;
    }
}
