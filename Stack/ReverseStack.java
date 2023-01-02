import java.util.*;
public class ReverseStack {
    public static void pushAtBottom(Stack <Integer>s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void reverseStack(Stack <Integer>s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }
    public static void print(Stack <Integer>s){
        int n = s.size();
        while(n>0){
            System.out.print(s.get(--n) + "  ");
        }
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            Stack<Integer> s = new Stack<>();
            char choice;
            do{
                System.out.print("Push data in stack: ");
                int data = sc.nextInt();
                s.push(data);
                System.out.print("Want to Push more data(t/f)?: ");
                choice = sc.next().charAt(0);
            }while(choice == 't' || choice == 'T');
            System.out.print("Original Stack: ");
            print(s);
            reverseStack(s);
            System.out.print("\nReversed Stack: ");
            print(s);
        }
    }
}
