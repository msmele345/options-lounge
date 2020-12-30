package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.Bid;
import com.mitchmele.optionslounge.option.repository.mongo.BidDORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BidService {

    private final BidDORepository bidDORepository;

    public List<Bid> getBids() {
        return bidDORepository.findAll();
    }

    public List<Bid> getAllBidsBySymbol(String symbol) {
        return bidDORepository.findAllBySymbol(symbol);
    }
}
