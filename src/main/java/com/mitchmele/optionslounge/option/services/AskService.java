package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.Ask;
import com.mitchmele.optionslounge.option.model.Bid;
import com.mitchmele.optionslounge.option.repository.mongo.AskDORepository;
import com.mitchmele.optionslounge.option.repository.mongo.BidDORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AskService {

    private final AskDORepository askDORepository;

    public List<Ask> getAsks() {
        return askDORepository.findAll();
    }
}
