package ITP4;

public class ArrayAvg {
    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5};
        int res = 0;
        try{
            for(int i : a){
                res += i;
                /*System.out.println(a[5]);*/
            }
            res /= a.length;
            System.out.println(res);
        } catch(ArithmeticException exception){
            System.out.println(exception + ", an array is empty");
        } catch(IndexOutOfBoundsException exception){
            System.out.println(exception);
        }
    }
}
