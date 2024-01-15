package ITP6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TopWords {
    public static void main(String[] args){
        try{
            Map<String, Integer> topwords = new HashMap<String,Integer>(){};
            List<String> all = new ArrayList<>();
            all = Files.readAllLines(Paths.get("ITP6\\Text1.txt"));
            String allwords = "";
            for(String i : all){
                allwords += i;
            }
            all = List.of(allwords.split(" "));

            int len = 0;
            String word = "";
            for(String i: all){
                word = i;
                for(String i1: all){
                    if (i1.equals(word)){
                        len += 1;
                    }
                }
                if (!topwords.containsKey(word)){
                    topwords.put(word, len);
                }
                len = 0;
            }
            List<Integer> countwords = new ArrayList<>(topwords.values());
            Collections.sort(countwords, Comparator.reverseOrder());
            Map<String, Integer> sortedMap = new HashMap<>();
            int it = 0;
            for (int i = 0; i < countwords.size(); i++) {
                for (Map.Entry<String, Integer> entry : topwords.entrySet()) {
                    if (it < 10){
                        if (entry.getValue().equals(countwords.get(i))) {
                            if(!sortedMap.containsKey(entry.getKey())){
                                it += 1;
                                System.out.println(entry.getKey() + " " + String.valueOf(countwords.get(i)));
                            }
                            sortedMap.put(entry.getKey(), countwords.get(i));
                        }
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
