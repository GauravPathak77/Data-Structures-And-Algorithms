import java.util.*;
public class substring{
    public static String subString(String str, int si, int ei){
        String subStr = "";
        for(int i=si; i<ei; i++){
            char ch = str.charAt(i);
            subStr += ch;
        }
        return subStr;
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter any string: ");
            String str = sc.next();
            System.out.print("Enter starting index of substring: ");
            int si = sc.nextInt();
            System.out.print("Enter ending index of substring: ");
            int ei = sc.nextInt();
            System.out.println("Substring is " + subString(str,si,ei));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}