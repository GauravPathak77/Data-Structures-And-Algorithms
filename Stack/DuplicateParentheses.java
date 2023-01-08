import java.util.*;
public class DuplicateParentheses {
    public static boolean isDuplicate(String str){
        Stack <Character>s = new Stack <>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch==')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }
                else{
                    s.pop();
                }
            }
            else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a string : ");
            String str = sc.next();
            if(isDuplicate(str)){
                System.out.println("Array contains Duplicate Parentheses");
            }
            else{
                System.out.println("Array does not contains Duplicate Parentheses");
            }
        }
    }
}
