import java.util.ArrayList;
import java.util.Collections;

public class HW2{
    static String isAnagram(String a, String b){
        if (a.length() == b.length()){
            ArrayList<Integer> aarray = new ArrayList<Integer>();
            ArrayList<Integer> barray = new ArrayList<Integer>();
            for (int i = 0; i < a.length(); i++){
                int aascii = a.charAt(i);
                int bascii = b.charAt(i);
                aarray.add(aascii);
                barray.add(bascii);
            }
            Collections.sort(aarray);
            Collections.sort(barray);
            if (barray.equals(aarray)){
                return"Yes";
            } else {
                return "No";
            }
        } else {
        return "No";
        }
    }
    public static void main(String[] args){
        System.out.println(isAnagram("silent", "lisent"));
        System.out.println(isAnagram("asasa", "bobob"));
    }
}