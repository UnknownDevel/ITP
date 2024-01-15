package ITP6;

import java.util.HashMap;
import java.util.Map;

public class Sales {

    private HashMap<String, Integer> saleslist;

    public void addsale(String key, Integer value){
        if (saleslist.containsKey(key)){
            saleslist.put(key, saleslist.get(key)+value);
        } else{
            saleslist.put(key, value);
        }
    }
    public void removesale(String key){
        saleslist.remove(key);
    }

    public Map<String, Integer> returnlist(){
        return saleslist;
    }
    public void printlist(){
        for(Map.Entry<String, Integer> i : saleslist.entrySet()){
            System.out.println("Product name: " + i.getKey() + "     Amount sold: " + i.getValue());
        }
    }
    public Map.Entry<String, Integer> returnmostpopular(){
        int max = 0;
        String prod = "";
        for(Map.Entry<String, Integer> i : saleslist.entrySet()){
            if (i.getValue() >= max){
                max = i.getValue();
                prod = i.getKey();
            }
        }
        return Map.entry(prod, max);
    }
    public int countsum(){
        int sum = 0;
        for(Map.Entry<String, Integer> i : saleslist.entrySet()){
            sum += i.getValue();
        }
        return sum;
    }
}
