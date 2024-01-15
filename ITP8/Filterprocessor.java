package ITP8;
import java.util.List;
import java.util.stream.Collectors;

public class Filterprocessor {
    @DataProcessor
    public List<String> filterData(List<String> sentences){
        List<String> filteredData = sentences.stream().filter(sentence -> sentence.contains("no")).collect(Collectors.toList());
        return filteredData;
    }
}
