import java.util.ArrayList;
import java.util.Arrays;

public class HW4 {
    public static String nonRepeatable(String a){
        char[] am = a.toCharArray();
        ArrayList<Character> aa = new ArrayList<>();
        ArrayList<Character> aa1 = new ArrayList<>();
        String res = "";
        for(char i : am){
            aa1.add(i);
        }
        for(int i = 0; i < aa1.size(); i++){
            if (aa.contains(aa1.get(i))){
                aa1.remove(i);
                for(char i1 : aa1){
                    res += i1;
                }
                return nonRepeatable(res);
            } else{
                aa.add(am[i]);
            }
        }
        for(char i : aa){
            res += i;
        }
        return(res);
    }
    public static ArrayList<String> binarySystem(int c){
        String bin;
        char[] bincar;
        char mem = ' ';
        boolean adding = true;
        ArrayList<String> fin = new ArrayList<>();
        for(int i = 0; i < Math.pow(2, c); i++){
            adding = true;
            mem = ' ';
            bin = Integer.toBinaryString(i);
            if (bin.length() < c){
                for(int ii = 0; ii <= c - bin.length(); ii++){
                    bin = '0' + bin;
                }
            }
            bincar = bin.toCharArray();
            for(char i1 : bincar){
                if (mem == i1 && mem == '0'){
                    adding = false;
                }
                mem = i1;
            }
            if (adding){
                fin.add(bin);
            }
        }
        return fin;
    }
    public static ArrayList<String> generateBrackets(int a){
        ArrayList<String> aa = new ArrayList<>();
        String newbr;
        String adding;
        String adding2;
        for(int i = 0; i < a; i++){
            newbr = "";
            adding = "";
            adding2 = "";
            if(i == 0){
                for(int i_ = 0; i_ < a; i_++){
                    newbr += "()";
                }
                aa.add(newbr);
            }
            else {
                for(int i1 = 0; i1 <= i; i1++){
                    adding += "(";
                    adding2 += ")";
                }
                for(int i1 = 0; i1 < a-i; i1++){
                    for(int i2 = i1+1; i2 < a-i+1; i2++){
                        newbr = "";
                        for(int i3 = 0; i3 < a-i+1; i3++){
                            if (i3 == i1){
                                newbr += adding;
                            }
                            else if (i3 == i2){
                                newbr += adding2;
                            }
                            else{
                                newbr += "()";
                            }
                        }
                        if (!aa.contains(newbr)){
                            aa.add(newbr);
                        }
                    }
                }
            }
        }
        return aa;
    }
    public static String alphabeticRow(String a){
        ArrayList<Character> ar = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String res = "";
        String finres = "";
        int len = 0;
        int maxlen = 0;
        for(char i : a.toCharArray()){
            ar.add(i);
        }
        for(int i = 0; i < ar.size()-1; i++){
            res = "";
            len = 0;
            for(int i1 = i; i1 < ar.size(); i1++){
                if(alphabet.contains(res)){
                    len = res.length();
                } else{
                    if (len > maxlen){
                        finres = res.substring(0, res.length()-1);
                        maxlen = len;
                    }
                }
                res += ar.get(i1);
            }
        }
        return finres;
    }
    public static String patternLength(String a){
        int len = 1;
        String res = "";
        char mem = ' ';
        String adding = "";
        ArrayList<String> finar = new ArrayList<>();
        for (int i = 0; i < a.toCharArray().length; i++){
            if (a.toCharArray()[i] != mem){
                adding += String.valueOf(len);
                finar.add(adding);
                adding = String.valueOf(a.toCharArray()[i]);
                len = 1;
                mem = a.toCharArray()[i];
            } 
            else{
                len++;
            }
        }
        adding += String.valueOf(len);
        finar.add(adding);
        for(int i = 1; i < finar.size(); i++){
            res += finar.get(i);
        }
        return res;
    }
    public static String convertToNum(String a){
        String[] abet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] abetdec = {"baby shark tutu turu turu baby shark tu tu turu turu", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] abetfirstdec = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        ArrayList<String> alphabet = new ArrayList<>();
        alphabet.addAll(Arrays.asList(abet));
        ArrayList<String> alphabetdec = new ArrayList<>();
        alphabetdec.addAll(Arrays.asList(abetdec));
        ArrayList<String> alphabetfirstdec = new ArrayList<>();
        alphabetfirstdec.addAll(Arrays.asList(abetfirstdec));

        String[] asp = a.split(" ");
        ArrayList<String> asplit = new ArrayList<>();
        asplit.addAll(Arrays.asList(asp));
        String res = "";
        int size = 0;
        boolean hasdec = false;
        boolean hasfirstdec = false;

        if (asplit.contains("thousand")){
            asplit.remove("thousand");
            res += String.valueOf(alphabet.indexOf(asplit.get(0)));
            asplit.remove(0);
        }
        if (asplit.contains("hundred")){
            asplit.remove("hundred");
            res += String.valueOf(alphabet.indexOf(asplit.get(0)));
            asplit.remove(0);
        } else if (res.length() != 0){
            res += "0";
        }
        for(String i : alphabetdec){
            if (asplit.contains(i)){
                res += String.valueOf(alphabetdec.indexOf(asplit.get(0)));
                asplit.remove(0);
                hasdec = true;
            }
        } for(String i : alphabetfirstdec){
            if(asplit.contains(i)){
                res += "1" + String.valueOf(alphabetfirstdec.indexOf(i)+1);
                hasfirstdec = true;
            } 
        }
        if(!hasfirstdec){
            if (!hasdec && res.length() != 0){
                res += "0";
            }
            if (asplit.size() == 0 && res.length() != 0){
                res += "0";
            } else{
                res += String.valueOf(alphabet.indexOf(asplit.get(0)));
            }
        }
        return res;
    }
    public static String uniqueSubString(String a){
        String sstr = "";
        String fin = "";
        for (char i : a.toCharArray()){
            if (!sstr.contains(String.valueOf(i))){
                sstr += i;
            } else{
                if (sstr.length() > fin.length()){
                    fin = sstr;
                }
                sstr = String.valueOf(i);
            }
        }
        if (sstr.length() > fin.length()){
            fin = sstr;
        }
        return fin;
    }
    public static int shortestWay(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] minways = new int[m][n];
        minways[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            minways[i][0] = minways[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            minways[0][j] = minways[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                minways[i][j] = grid[i][j] + Math.min(minways[i-1][j], minways[i][j-1]);
            }
        }
        return minways[m-1][n-1];
    }
    public static String numericOrder(String a){
        String res = "";
        String[] as = a.split(" ");
        String alph = "1234567890";
        ArrayList<String> l = new ArrayList<>();
        for(int i = 0; i < as.length; i++){
            l.add("");
        }
        for(String i : as){
            String icln = i;
            for(char i1 : i.toCharArray()){
                if (!alph.contains(String.valueOf(i1))){
                    icln = icln.replace(String.valueOf(i1), "");
                }
            }
            l.set(Integer.valueOf(icln)-1, i.replace(icln, ""));
        }
        for(String i : l){
            res += i + " ";
        }
        return res;
    }
    public static String switchNums(String a, String b){
        String res = "";
        int indexmax;
        ArrayList<Character> ac = new ArrayList<>();
        for(char i : a.toCharArray()){
            ac.add(i);
        }
        for(char i : b.toCharArray()){
            indexmax = -1;
            for(int i1 = 0; i1 < ac.size(); i1++){
                if(Integer.valueOf(ac.get(i1)) > Integer.valueOf(i)){
                    indexmax = i1;
                }
            }
            if (indexmax != -1){
                res += ac.get(indexmax);
                ac.remove(indexmax);
            } else{
                res += i;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(nonRepeatable("bbcdacfgd"));
        System.out.println(generateBrackets(5));
        System.out.println(binarySystem(3));
        System.out.println(alphabeticRow("abcd=ffasdrfguvwxyzjg"));
        System.out.println(patternLength("aaaabbbbcddddaaaaabbaaxx      %$$$ "));
        System.out.println(convertToNum("nine thousand fifty six"));
        System.out.println(uniqueSubString("11221124531143"));
        System.out.println(numericOrder("I2 D1o go3 pa7rk a6musement 4to th5e ri9de and8 ?13 t10he f11erris wh12eel"));
        System.out.println(switchNums("96", "8731"));
        System.out.println(shortestWay(new int[][]{{1, 2, 3}, {1, 2, 3}, {3, 2, 1}}));
    }
}
