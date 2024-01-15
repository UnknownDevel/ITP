import java.util.Scanner;
import java.util.ArrayList;

public class Contest2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        for(int i = 0; i < n; i++){
            a1 = new ArrayList<>();
            for(int i1 = 0; i1 < m; i1++){
                a1.add(scan.nextInt());
            }
            a.add(a1);
        }
        scan.close();

        int size = 0;
        boolean brek = false;
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        ArrayList<Integer> ar1 = new ArrayList<>();
        for(int i = 0; i < Math.min(a.size(), a.get(0).size()); i++){
            for(int i1 = 0; i1 < a.get(0).size()-i; i1++){
                for(int i2 = 0; i2 < a.size()-i; i2++){
                    brek = false;
                    for(int i4 = i2; i4 < i2 + i; i4++){
                        for(int i5 = i1; i5 < i1 + i; i5++){
                            if(a.get(i4).get(i5) == 0){
                                brek = true;
                            }
                        }
                    }
                    if (!brek){
                        size = i+1;
                    }
                }
            }
        }
        System.out.println(size);
    }
}
