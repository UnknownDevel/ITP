import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.*;
import java.util.Random;
//irrelevant comment
//completely different comment

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
    static Boolean duplicateChars(String a){
        char mem = ' ';
        for (int i = 1; i < a.length(); i++){
            if (Character.toLowerCase(a.charAt(i)) == mem){
                return true;
            }
            mem = Character.toLowerCase(a.charAt(i-1));
        }
        return false;
    }
    static String getInitials(String a){
        String res = "";
        for (int i = 0; i < a.length(); i++){
            if (Character.isUpperCase(a.charAt(i))){
                res += a.charAt(i);
            }
        }
        return res;
    }
    static Integer differenceEvenOdd(int[] a){
        int sumeven = 0;
        int sumodd = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] % 2 == 0){
                sumeven += a[i];
            }
            else {
                sumodd += a[i];
            }
        }
        return Math.abs(sumeven - sumodd);
    }
    static Boolean equalToAvg(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            sum += a[i];
        }
        sum = sum / a.length;
        for (int i = 0; i < a.length; i++){
            if (a[i] == sum){
                return true;
            }
        }
        return false;
    }
    static int[] indexMulti(int[] a){
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++){
            b[i] = a[i]*i;
        }
        return b;
    }
    static String reverse(String a){
        String b = "";
        for(int i = 0; i < a.length(); i++){
            b = String.valueOf(a.charAt(i)) + b;
        }
        return b;
    }
    static int tribonachi(int a){
        if (a == 1){
            return 0;
        } else if (a == 2){
            return 0;
        } else if (a == 3){
            return 1;
        }
        return tribonachi(a-1) + tribonachi(a-2) + tribonachi(a-3);
    }
    static String pseudoHash(int a){
        String newstr = "";
        String[] arr = new String[] {"e", "0", "5", "6", "7", "8", "9", "4", "c", "2", "3", "1", "b", "a", "d", "f"};
        for (int i = 0; i < a; i++){
            int ran = new Random().nextInt(arr.length-1);
            newstr = newstr + arr[ran];
        }
        return newstr;
    }
    static String botHelper(String a){
        String[] b = a.split(" ");
        if (Arrays.asList(b).contains("help")){
            return "I was ordered to tell you that I am helping, but I am just a program that returns a string, so... sorry, nothing I can do";
        } else{
            return "I am too stupid to process your information, I contain 5 lines of code so the only word I can process is 'help'";
        }
    }
    public static void main(String[] args){
        System.out.println(isAnagram("silent", "lisent"));
        System.out.println(isAnagram("asasa", "bobob"));


        System.out.println(duplicateChars("silent"));
        System.out.println(duplicateChars("asasa"));


        System.out.println(getInitials("Barack Obama"));


        int[] arr = {12, 13, 14, 23, 52, 33};
        System.out.println(differenceEvenOdd(arr));


        arr = new int[] {1, 2, 3, 4, 5};
        System.out.println(equalToAvg(arr));


        System.out.println(Arrays.toString(indexMulti(arr)));


        System.out.println(reverse("When the impostor among us is SUS!!!"));
        

        System.out.println(tribonachi(11));


        System.out.println(pseudoHash(32));


        System.out.println(botHelper("please help"));
    }
}