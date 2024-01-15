import java.util.ArrayList;
import java.util.Arrays;

public class HW3 {
    public static String replaceVowels(String a){
        char[] charr = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        for (int i = 0; i < charr.length; i++){
            a = a.replaceAll(String.valueOf(charr[i]), "*");
        }
        return a;
    }
    public static String modifyStr(String a){
        char[] ach = a.toCharArray();
        for (int i = 0; i < ach.length-1; i++){
            if (ach[i+1] == ach[i]){
                String tempstr = String.valueOf(ach[i]) + String.valueOf(ach[i+1]);
                a = a.replaceAll(tempstr, "Double"+String.valueOf(ach[i]).toUpperCase());
            }
        }
        return a;
    }
    public static Boolean doesBlockFit(int[] a){
        int b = 0;
        for (int i = 0; i < 3; i++){
            if (a[i] <= a[3] || a[i] <= a[4]){
                b += 1;
            }
        }
        if (b >= 2){
            return true;
        }
        return false;
    }

    public static Boolean numCheck(int a){
        char[] c = String.valueOf(a).toCharArray();
        int b = 0;
        for (int i = 0; i < c.length; i++){
            b += Character.getNumericValue(c[i])^2;
        }
        if (a%2 == b%2){
            return true;
        }
        return false;
    }
    public static int countRoots(int[] a){
        int c = 0;
        double s1 = (-a[1]+Math.sqrt(a[1]*a[1]-4*a[0]*a[2]))/(2*a[0]);
        double s2 = (-a[1]-Math.sqrt(a[1]*a[1]-4*a[0]*a[2]))/(2*a[0]);
        if (s1 == (int)s1){
            c++;
        }
        if (s2 ==(int)s2){
            c++;
        }
        if (s2 == s1){
            if (s1 == (int)s1){
                return 1;
            }
        }
        return c;
    }
    public static String[] salesData(String[][] a){
        int max = 0;
        ArrayList<String> finarr = new ArrayList<String>();
        for (int i = 0; i < a.length; i++){
            if (a[i].length > max){
                max = a[i].length;
                finarr = new ArrayList<>();
                finarr.add(a[i][0]);
            } else if (a[i].length == max){
                finarr.add(a[i][0]);
            }
        }
        String[] s = {};
        return finarr.toArray(s);
    }
    public static Boolean validSplit(String a){
        String[] s = a.split(" ");
        for (int i = 1; i < s.length; i++){
            if (s[i].charAt(0) != s[i-1].charAt(s[i-1].length()-1)){
                return false;
            }
        }
        return true;
    }

    public static Boolean waveForm(int[] a){
        for(int i = 1; i < a.length-1; i++){
            if (!((a[i] > a[i-1] && a[i+1] < a[i])||(a[i] < a[i-1] && a[i+1] > a[i]))){
                return false;
            }
        }
        return true;
    }

    public static char commonVowel(String a){
        String set = "aeiouy";
        int counter = 0;
        int countermax = 0;
        char[] b = a.toCharArray();
        Arrays.sort(b);
        char ch = ' ';
        for(int i = 0; i < b.length-1; i++){
            for (char i1: set.toCharArray()){
                if (b[i] == i1){
                    if (b[i]==b[i+1]){
                        counter += 1;
                    } else {
                        if (counter > countermax){
                            ch = b[i];
                            countermax = counter;
                            counter = 0;
                        }
                    }
                }
            }
        }
        return ch;
    }

    public static int[][] dataScience(int[][] a){
        int s = 0;
        for (int i = 0; i < a.length; i++){
            for (int i1 = 0; i1 < a.length; i1++){
                s += a[i1][i];
            }
            s = Math.round(((float)(s-a[i][i]))/(a[i].length-1));
            a[i][i] = s;
            s = 0;
        }
        return a;
    }
    public static void main(String[] args){
        System.out.println(replaceVowels("Impostor among us"));

        System.out.println(modifyStr("hooligaan"));

        System.out.println(doesBlockFit(new int[]{1, 8, 1, 1, 1}));

        System.out.println(numCheck(243));

        System.out.println(countRoots(new int[]{2, 5, 2}));

        System.out.println(Arrays.toString(salesData(new String[][]{
            new String[]{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
            new String[]{"Banana", "Shop2", "Shop3", "Shop4"},
            new String[]{"Orange", "Shop1", "Shop3", "Shop4"},
            new String[]{"Pear", "Shop2", "Shop4"}})));
        System.out.println(Arrays.toString(salesData(new String[][]{
            new String[]{"Fridge", "Shop2", "Shop3"},
            new String[]{"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
            new String[]{"Laptop", "Shop3", "Shop4"},
            new String[]{"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}})));

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("amm amm"));

        System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[]{1, 2, 3, 4, 3}));

        System.out.println(commonVowel("Helelo woerld"));

        int [][] f = dataScience(new int[][]{
                            new int[]{1, 2, 3, 4, 5},
                            new int[]{6, 7, 8, 9, 10},
                            new int[]{5, 5, 5, 5, 5},
                            new int[]{7, 4, 3, 14, 2},
                            new int[]{1, 0, 11, 10, 13}});
        for (int i = 0; i < f.length;i++){
            System.out.print(Arrays.toString(f[i])+ ", ");
        }
        
    }
}
