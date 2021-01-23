package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.StockMetadata;
import com.mitchmele.optionslounge.option.repository.StockMetadataRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("h2")
@Tag("IT")
@SpringBootTest
class StockMetadataServiceIT {

    @Autowired
    private StockMetadataService stockMetadataService;

    @Autowired
    private StockMetadataRepository repository;

    @Test
    void getMetadata_returnsAllDetailsFromRepoForProvidedSymbol() {

        StockMetadata actual = stockMetadataService.getMetadata("AADR");

        assertThat(actual.getTicker()).isEqualTo("AADR");
    }
}