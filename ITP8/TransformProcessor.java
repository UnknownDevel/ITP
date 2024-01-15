package ITP8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransformProcessor {
    @DataProcessor
    public List<String> transformData(List<String> sentences){
        List<String> transformedData = new ArrayList<>();
        transformedData = sentences.stream().map(String::toLowerCase).collect(Collectors.toList());
        return transformedData;
    }
}
