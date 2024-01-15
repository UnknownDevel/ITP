import java.util.Scanner;

public class Contest{
	public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int xstart = scan.nextInt();
        int ystart = scan.nextInt();
        int xfin = scan.nextInt();
        int yfin = scan.nextInt();
        scan.close();

        double hyp = Math.abs(Math.sqrt(Math.pow(xfin, 2)+ Math.pow(yfin,2)) - Math.sqrt(Math.pow(xstart, 2)+Math.pow(ystart, 2))); 

        Long al = Long.valueOf(xstart) * Long.valueOf(xfin) + Long.valueOf(ystart) * Long.valueOf(yfin);
        double a = (double)al;
        double b = Math.sqrt(Math.pow(xfin, 2) + Math.pow(yfin,2)) * Math.sqrt(Math.pow(xstart, 2)+Math.pow(ystart, 2));

        double sphere = Math.min(Math.sqrt(Math.pow(xfin, 2)+Math.pow(yfin,2)), Math.sqrt(Math.pow(xstart, 2)+Math.pow(ystart, 2)))*
        Math.acos(a/b);

        System.out.println(Math.min(hyp + sphere, Math.sqrt(Math.pow(xfin, 2)+ Math.pow(yfin,2)) + Math.sqrt(Math.pow(xstart, 2)+Math.pow(ystart, 2))));  
    }
}
