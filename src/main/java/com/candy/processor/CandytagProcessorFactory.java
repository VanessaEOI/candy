package com.candy.processor;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CandytagProcessorFactory {

    private final Map<String, CandytagProcessor> processorMap = new HashMap<>();

    public CandytagProcessorFactory(List<CandytagProcessor> processors) {
        for (CandytagProcessor processor : processors) {
            processorMap.put(processor.getCandytagName(), processor);
        }
    }

    public CandytagProcessor getCandytagProcessor(String candytagName) {
        return processorMap.get(candytagName);
    }
}