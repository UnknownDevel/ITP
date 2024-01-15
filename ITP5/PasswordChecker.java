package ITP5;
import java.util.regex.*;

public class PasswordChecker {
    public static void main(String[] args){
        try{
            Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[A-Z]).{8,16})");
            String pass = "a1sdffgdsfrewAka";
            Matcher m = pattern.matcher(pass);
            if (m.matches()){
                System.out.println("Good Password");
            } else{
                System.out.println("Not so good Password");
            }
        } catch (IllegalStateException ex){
            System.out.println("Illegal state. Call .find before using .group" );
        } catch (PatternSyntaxException ex){
            System.out.println("Wrong pattern syntax. Description: " + ex.getMessage() + ": " + ex.getPattern() );
        }
    }
}
