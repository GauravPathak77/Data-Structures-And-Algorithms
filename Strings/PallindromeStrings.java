import java.util.*;
public class PallindromeStrings{
    public static boolean isPallindrome(String str){
        for(int i=0; i<str.length()/2; i++){
            int n = str.length();
            if(str.charAt(i) != str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter any string: ");
            String str = sc.next();
            if(isPallindrome(str)){
                System.out.println("Entered string is Pallindrome");
            }
            else{
                System.out.println("Entered string is not Pallindrome");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}