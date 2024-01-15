package ITP1;

public class Palindrome {
    public static String reverseString(String s){
        String s1 = "";
        for (int i = s.length()-1; i >= 0; i--){
            s1 = s1 + s.charAt(i);
        }
        return s1;
    }
    public static boolean isPalindrome(String s){
        if (s.equals(reverseString(s))){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args){
        String s = "";
        for (int i = 0; i < args.length; i++) {
            s = args[i];
            System.out.println(isPalindrome(s));
        }
    }
}
