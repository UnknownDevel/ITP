package ITP5;
import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        try{
            String text = "The price of the product is $19.99";
            Pattern pattern = Pattern.compile("\\d+\\.\\d+");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (IllegalStateException ex){
            System.out.println("Illegal state. Call .find before using .group" );
        } catch (PatternSyntaxException ex){
            System.out.println("Wrong pattern syntax. Description: " + ex.getMessage() + ": " + ex.getPattern() );
        }
    } 
}
