import java.util.*;
public class ConvertLettersToUpperCase {
    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ' ' && i< str.length()-1){
                sb.append(ch);
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter any string that may contain more than one words: ");
            String str = sc.nextLine();
            String newStr = toUpperCase(str);
            System.out.println("String after converting each first letter of each word to uppercase is: " + newStr);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
