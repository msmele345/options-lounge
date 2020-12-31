package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.StockMetadata;
import com.mitchmele.optionslounge.option.repository.StockMetadataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockMetadataService {

    private final StockMetadataRepository stockMetadataRepository;

    public StockMetadata getMetadata(String symbol) {
        return stockMetadataRepository.findByTicker(symbol);
    }
}
