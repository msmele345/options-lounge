package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.Ask;
import com.mitchmele.optionslounge.option.model.Bid;
import com.mitchmele.optionslounge.option.model.StockSnapshot;
import com.mitchmele.optionslounge.option.repository.StockMetadataRepository;
import com.mitchmele.optionslounge.option.repository.mongo.AskDORepository;
import com.mitchmele.optionslounge.option.repository.mongo.BidDORepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuoteDataService {

    private final QuoteDataHelper dataHelper;
    private final BidDORepository bidDORepository;
    private final AskDORepository askDORepository;
    private final StockMetadataRepository stockMetadataRepository;

    public void generateData() {

        List<StockSnapshot> stocks = stockMetadataRepository.findAll().stream()
                .map(stock -> StockSnapshot.builder().symbol(stock.getTicker()).price(stock.getPrice()).build())
                .collect(Collectors.toList());

        stocks.forEach( stock -> {

            log.info("SAVING BIDS FOR STOCK: " + stock.getSymbol());
            bidDORepository.save(Bid.builder().bidPrice(BigDecimal.valueOf(stock.getPrice())).symbol(stock.getSymbol()).build());
            bidDORepository.save(Bid.builder().bidPrice(dataHelper.nextBid(stock.getPrice())).symbol(stock.getSymbol()).build());
            bidDORepository.save(Bid.builder().bidPrice(dataHelper.nextBid(stock.getPrice())).symbol(stock.getSymbol()).build());
            bidDORepository.save(Bid.builder().bidPrice(dataHelper.nextBid(stock.getPrice())).symbol(stock.getSymbol()).build());


            log.info("SAVING ASK FOR STOCK: " + stock.getSymbol());
            askDORepository.save(Ask.builder().askPrice(dataHelper.nextAsk(stock.getPrice())).symbol(stock.getSymbol()).build());
            askDORepository.save(Ask.builder().askPrice(dataHelper.nextAsk(stock.getPrice())).symbol(stock.getSymbol()).build());
            askDORepository.save(Ask.builder().askPrice(dataHelper.nextAsk(stock.getPrice())).symbol(stock.getSymbol()).build());
            askDORepository.save(Ask.builder().askPrice(dataHelper.nextAsk(stock.getPrice())).symbol(stock.getSymbol()).build());

        });
    }
}
