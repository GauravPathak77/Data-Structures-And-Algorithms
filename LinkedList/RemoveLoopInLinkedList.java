import java.util.*;
public class RemoveLoopInLinkedList {
        public static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
        public static Node head;
        public static Node tail;

        // print
        public static void printLL() {
            if (head == null) {
                System.out.println("Empty LinkedList");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.print("null");
        }

        // remove cycle/loop in LL  
        public static void removeCycle(){
            // Detect loop/cycle
            Node slow = head;
            Node fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    break;
                }
            }
        
            // Remove loop/cycle
            slow = head;
            Node prev = head;
            while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }
    
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            head = new Node(1);
            Node temp = new Node(2);
            head.next = temp;
            head.next.next = new Node(3);
            head.next.next.next = temp;
            System.out.println("Linked after removing cycle is: ");
            removeCycle();
            printLL();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
