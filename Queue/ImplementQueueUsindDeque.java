import java.util.*;
public class ImplementQueueUsindDeque {
    static class Queue{
        Deque<Integer> deque = new LinkedList<>();

        public boolean isEmpty(){
            return deque.isEmpty();
        }
        // add
        public void add(int data){
            deque.addLast(data);
        }
        // remove
        public int remove(){
            return deque.removeFirst();
        }
        // peek
        public int peek() {
            return deque.getFirst();
        }
    }
    
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            Queue s = new Queue();
            char choice;
            do {
                System.out.print("Enter data: ");
                int data = sc.nextInt();
                s.add(data);
                System.out.print("Want to push more data(y/n): ");
                choice = sc.next().charAt(0);
            } while (choice == 'y');
            // print
            while (!s.isEmpty()) {
                System.out.println(s.peek() + " ");
                s.remove();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
