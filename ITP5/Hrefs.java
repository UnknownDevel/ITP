package ITP5;
import java.util.regex.*;

public class Hrefs {
    public static void main(String[] args){
        try{
            String mess = "тут какой-то текст www.google.com www.google.com http://www.google.com тут текст*текст курсивом* google.com https://google.com ftp://ftp.com";

            Pattern pat = Pattern.compile("(https?|ftp|file)://[\\w-+&@#/%?=~|!:,.;]*");
            Matcher m = pat.matcher(mess);
            if (m.find()){
                System.out.println(m.replaceAll("<a>href=\"$0\"</a>"));
            }
        } catch (IllegalStateException ex){
            System.out.println("Illegal state. Call \".find\" before using \".group\"" );
        } catch (PatternSyntaxException ex){
            System.out.println("Wrong pattern syntax. Description: " + ex.getMessage() + ": " + ex.getPattern() );
        }
    }
}
