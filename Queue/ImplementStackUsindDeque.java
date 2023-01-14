import java.util.*;
public class ImplementStackUsindDeque {
    static class Stack{
        static Deque<Integer> deque = new LinkedList<>();
        public boolean isEmpty(){
            return deque.isEmpty();
        }
        // push
        public void push(int data){
            deque.addLast(data);
        }
        // pop
        public int pop(){
            return deque.removeLast();
        }
        // peek
        public int peek(){
            return deque.getLast();
        }
    }

    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            Stack s = new Stack();
            char choice;
            do{
                System.out.print("Enter data: ");
                int data = sc.nextInt();
                s.push(data);
                System.out.print("Want to push more data(y/n): ");
                choice = sc.next().charAt(0);
            }while(choice == 'y');
            // print
            while(!s.isEmpty()){
                System.out.println(s.peek()+ " ");
                s.pop();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
