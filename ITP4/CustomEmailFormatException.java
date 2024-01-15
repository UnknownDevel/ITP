package ITP4;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomEmailFormatException extends Exception {
    public CustomEmailFormatException(){}
    public static void email(String email) throws CustomEmailFormatException {
        char[] mass = email.toCharArray();
        Pattern pat = Pattern.compile("\\w+[@]\\w+[.]\\w+");
        Matcher m = pat.matcher(email);
        if (m.matches()){
            System.out.println("Good");
        }else {
            throw new CustomEmailFormatException();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.print("Enter e-mail address: ");
            Scanner scanner = new Scanner(System.in);
            String email = scanner.nextLine();
            email(email);
        } catch (CustomEmailFormatException e){
            System.out.println("Incorrect e-mail address");
        }
    }
}