import java.util.*;
public class ReverseString {
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            s.push(str.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        str = result.toString();
        return str;
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            String str;
            System.out.println("Enter Any String: ");
            str = sc.next();
            str = reverseString(str);
            System.out.println("Reversed String: " + str);
        }
    }
}
