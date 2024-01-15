package ITP8;

import java.util.List;

public class Aggregateprocessor {
    public String aggregateData(List<String> sentences){
        StringBuilder aggregatedData = new StringBuilder();
        for(String sentence : sentences){
            aggregatedData.append(sentence + "\n");
        } 
        return aggregatedData.toString().trim();
    }
}
