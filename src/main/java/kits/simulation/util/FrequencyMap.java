package kits.simulation.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyMap<T> {

    private final Map<T, Long> frequencyMap = new HashMap<>();
    
    public void put(T elem) {
        frequencyMap.merge(elem, 1L, Long::sum);
    }
    
    public long frequency(T object) {
        return frequencyMap.getOrDefault(object, 0L);
    }
    
    public double frequencyPercent(T object) {
        return ((double)frequency(object)) / frequencyMap.values().stream().mapToLong(s -> s).sum();
    }
    
    @Override
    public String toString() {
        Map<T, Long> sortedByFrequency = frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        return sortedByFrequency.toString();
    }
    
}
