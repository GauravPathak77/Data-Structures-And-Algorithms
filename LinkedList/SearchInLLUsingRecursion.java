import java.util.*;
public class SearchInLLUsingRecursion{
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
// search using recursion
    public int helper(Node head, int key){
        if( head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
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

            // search using recursion
            System.out.print("Want to search data in LinkedList? (y/n): ");
            ch = sc.next().charAt(0);
            while (ch == 'y') {
                System.out.print("Enter data of that node in LinkedList: ");
                int key = sc.nextInt();
                System.out.println(key + " found at " + ll.recSearch(key));
                System.out.print("Want to search more data ? (y/n): ");
                ch = sc.next().charAt(0);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}