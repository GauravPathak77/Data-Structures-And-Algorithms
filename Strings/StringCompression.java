import java.util.*;
public class StringCompression {
    public static String stringCompress(String str){
        String newStr = "";
        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count>1){
                newStr += count.toString();
            }
        }
        return newStr;
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter any string that may contain repeating characters: ");
            String str = sc.next();
            String newStr = stringCompress(str);
            System.out.println("After compression string becomes: " + newStr);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
