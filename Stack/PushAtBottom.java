import java.util.*;
public class PushAtBottom {
    public static void pushAtBottom(Stack <Integer>s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void print(Stack <Integer>s){
        int n = s.size();
        while(n>0){
            System.out.print(s.get(--n) + "  ");
        }
    }
    public static void main(String args[]) {
        try(Scanner sc = new Scanner(System.in)){
            Stack<Integer> s = new Stack<>();
            s.push(2);
            s.push(3);
            s.push(4);
            s.push(5);
            System.out.println("Enter data to enter at the bottom of stack: ");
            int data = sc.nextInt();
            System.out.println("Original stack: ");
            print(s);
            pushAtBottom(s, data);
            System.out.println("\nAfter pushing at the bottom of stack: ");
            print(s);
        }
    }
}