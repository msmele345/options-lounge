package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.StockMetadata;
import com.mitchmele.optionslounge.option.repository.StockMetadataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StockMetadataServiceTest {

    @Mock
    private StockMetadataRepository repository;

    @InjectMocks
    private StockMetadataService stockMetadataService;

    @Test
    void getMetadata_returnsAllDetailsFromRepoForProvidedSymbol() {

        StockMetadata expected = StockMetadata.builder()
                .ticker("AADR")
                .sector("Financial")
                .change(0.064)
                .averageVolume(10.07)
                .build();

        when(repository.findByTicker(anyString())).thenReturn(expected);

        StockMetadata actual = stockMetadataService.getMetadata("AADR");

        assertThat(actual).isEqualTo(expected);
    }
}