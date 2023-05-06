import java.util.*;
public class ValidParentheses {
    public static boolean isValid(String str){
        Stack <Character>s = new Stack <>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch =='{'){
                s.push(ch);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '[' && ch == ']')
                        || (s.peek() == '{' && ch == '}')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter any string containing brackets: ");
            String str = sc.next();
            if(isValid(str)){
                System.out.println("String is valid");
            }
            else{
                System.out.println("String is not valid");
            }
        }
    }
}
