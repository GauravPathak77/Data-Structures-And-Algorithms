import java.util.*;
public class FindAndRemoveNodeFromEnd {
    public static class LinkedList {
        public class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public static Node head;
        public static Node tail;
        public static int size = 0;

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

       // Delete Nth Node from end i.e. (size - N + 1)th Node from start
        public void deleteNthFromEnd(int n){
            // size
            Node temp = head;
            int sz = 0;
            while(temp != null){
                temp = temp.next;
                sz++;
            }
            // Delete 1st Node
            if(n == sz){
                head = head.next;
                return;
            }
            // sz-n
            Node prev = head;
            int i = 1, idx = sz-n;
            while(i < idx){
                prev = prev.next;
                i++;
            }
            prev.next = prev.next.next;
            return;
       }
    }
    
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            LinkedList ll = new LinkedList();
            char ch;
            // addLast
            System.out.print("Want to enter data at the end of LinkedList? (y/n): ");
            ch = sc.next().charAt(0);
            while (ch == 'y') {
                System.out.print("Enter data at the end of LinkedList: ");
                int data = sc.nextInt();
                ll.addLast(data);
                System.out.print("Want to enter more data ? (y/n): ");
                ch = sc.next().charAt(0);
            }

            // removeLast
            System.out.print("Want to remove data from the end of LinkedList? (y/n): ");
            ch = sc.next().charAt(0);
            while (ch == 'y') {
                System.out.println(ll.removeLast() + " get removed from LinkedList");
                System.out.print("Want to remove more data ? (y/n): ");
                ch = sc.next().charAt(0);
            }

            // print
            System.out.print("Want to print LinkedList? (y/n): ");
            ch = sc.next().charAt(0);
            if (ch == 'y') {
                System.out.println("LinkedList is: ");
                ll.printLL();
            }

            // ReverseLL
            System.out.print("\nWant to delete node from end LinkedList? (y/n): ");
            ch = sc.next().charAt(0);
            if (ch == 'y') {
                System.out.print("Which Node do you want to delete? ");
                int n = sc.nextInt();
                ll.deleteNthFromEnd(n);
                System.out.println("After deletion the LinkedList becomes: ");
                ll.printLL();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

