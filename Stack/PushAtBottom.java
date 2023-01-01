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
            String choice;
            do {
                System.out.println("Push data in stack: ");
                int data = sc.nextInt();
                s.push(data);
                System.out.println("Want to Push more data(T/F)?: ");
                choice = sc.next();
            } while (choice == "T");
            System.out.println("Enter data to enter at the bottom of stack: ");
            int newdata = sc.nextInt();
            System.out.println("Original stack: ");
            print(s);
            pushAtBottom(s, newdata);
            System.out.println("\nAfter pushing at the bottom of stack: ");
            print(s);
        }
    }
}