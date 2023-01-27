import java.util.*;
public class Zig_ZagLinkedList {
    public static class LinkedList {
        public static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public Node head;
        public Node tail;
        public int size = 0;

        // addLast
        public void addLast(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
            size++;
        }

        // removeLast
        public int removeLast() {
            if (head == null) {
                System.out.println("Empty LinkedList");
                return -1;
            }
            int data = tail.data;
            size--;
            if (head == tail) {
                head = tail = null;
                return data;
            }
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            temp.next = null;
            return data;
        }

        // print
        public void printLL() {
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

        // Zig-Zag LinkedList
        public void zigZag() {
            // Middle Node
            Node slow = head;
            Node fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;
            // Reverse 2nd half
            Node curr = mid.next;
            mid.next = null;
            Node prev = null;
            Node next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node left = head;
            Node right = prev;
            Node nextL, nextR;
            // alternate merge
            while (left != null && right != null) {
                nextL = left.next;
                left.next = right;
                nextR = right.next;
                right.next = nextL;
                left = nextL;
                right = nextR;
            }
        }
    }
    
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            LinkedList ll = new LinkedList();
            char choice;
            do {
                System.out.print("Enter data in LinkedList: ");
                int data = sc.nextInt();
                ll.addLast(data);
                System.out.print("Want to enter more data?(y/n): ");
                choice = sc.next().charAt(0);
            } while (choice == 'y');
            System.out.println("Original LinkedList: ");
            ll.printLL();
            ll.zigZag();
            System.out.println("\nZig-Zag LinkedList: ");
            ll.printLL();
        } catch (Exception e) {
            System.out.println(e);
        }
    }  
}
