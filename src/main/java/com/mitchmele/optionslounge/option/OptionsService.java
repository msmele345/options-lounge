package com.mitchmele.optionslounge.option;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionsService {

    private final OptionRepository optionRepository;

    public List<Option> getOptions() {
        return optionRepository.findAll();
    }
}
