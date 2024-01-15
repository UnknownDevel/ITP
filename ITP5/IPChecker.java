package ITP5;

import java.util.regex.*;

public class IPChecker {
    public static void main(String[] args){
        try{
            String IP = "252.133.154.215";
            Pattern p = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$");
            Matcher m = p.matcher(IP);

            if(m.matches()){
                System.out.println("Its an IP!!!");
            }
        } catch (IllegalStateException ex){
            System.out.println("Illegal state. Call .find before using .group" );
        } catch (PatternSyntaxException ex){
            System.out.println("Wrong pattern syntax. Description: " + ex.getMessage() + ": " + ex.getPattern() );
        }
    }
}
