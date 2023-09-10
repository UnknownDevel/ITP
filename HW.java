public class HW{
    static float convert(int x){
            return x * 3.785f;
        }
    static int fitCalc(int cals, int intensity){
        if (intensity <= 3 && intensity > 0){
            return (cals * intensity);
        }
        else{
            return -1;
        }
    }
    static int containers(int boxes, int bags, int barrels){
        return boxes*20 + bags*50 + barrels*100; 
    }
    static String triangleType(int x, int y, int z){
        if (x == y && x == z && y == z){
            return "isosceles";
        }
        else if (x == y || x == z || y == z){
            return "equilateral";
        }
        else if (Math.min(x+y, Math.min(y + z, x + z)) <= Math.max(x, Math.max(y, z))){
            return "Non-existent";
        }
        else{
            return "Different sided";
        }
    }
    static int howManyItems(double n, double w, double h){
        return (int)Math.floor((n/2)/(w*h));
    }
    static int ternaryEvaluation(int a, int b){
        return a >= b ? a : b;
    }
    static int factorial(int a){
        int b = 1;
        for (int i = 1; i <= a; i++){
            b *= i;
        }
        return b;
    }
    static int gcd(int a, int b){
        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--){
            if (a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }
    static int ticketSaler(int a, int b){
        return (int)Math.floor(a*b*0.72);
    }
    static int tables (int a, int b){
        return (int)Math.ceil((double)(a-b*2)/2);
    }
    public static void main(String[] args){
        System.out.println(convert(1313));
        System.out.println(fitCalc(2, 1));
        System.out.println(fitCalc(23, 5));
        System.out.println(containers(2, 3, 5));
        System.out.println(triangleType(1, 12, 2));
        System.out.println(ternaryEvaluation(2, 3));
        System.out.println(howManyItems(22, 1.1, 1.1));
        System.out.println(factorial(4));
        System.out.println(gcd(18, 27));
        System.out.println(ticketSaler(70, 1500));
        System.out.println(tables(7,2));
    }
}