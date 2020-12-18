package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.Trade;
import com.mitchmele.optionslounge.option.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TradesService {

    private final TradeRepository tradeRepository;

    public List<Trade> fetchAllTrades() throws IOException {
        try {
            return tradeRepository.findAll();
        } catch (Exception e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public List<Trade> fetchTradesForSymbol(String symbol) throws IOException {
        try {
            return tradeRepository.findAllBySymbol(symbol);
        } catch (Exception e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }
}
