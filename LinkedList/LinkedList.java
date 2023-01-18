import java.util.*;
public class LinkedList {
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

        // addFirst
        public void addFirst(int data){
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
            size++;
    }

    // addLast
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    // removeFirst
    public static int removeFirst(){
        if(head == null){
            System.out.println("Empty LinkedList");
            return -1;
        }
        int data = head.data;
        size--;
        if(head == tail){
            head = tail = null;
            return data;
        }
        head = head.next;
        return data;
    }

    // removeLast
    public static int removeLast(){
         if(head == null){
            System.out.println("Empty LinkedList");
            return -1;
        }
        int data = tail.data;
        size--;
        if(head == tail){
            head = tail = null;
            return data;
        }
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        tail = temp;
        temp.next = null;
        return data;
    }

    // print
    public static void printLL(){
        if(head == null){
            System.out.println("Empty LinkedList");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    // search
    public static int search(int key) {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        }
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Element not found! ");
        return Integer.MIN_VALUE;
    }

    public static void main(String args[]) {
        try(Scanner sc = new Scanner(System.in)){
            LinkedList ll = new LinkedList();
            char ch;
            // addFirst
            System.out.print("Want to enter data at the starting of LinkedList? (y/n): ");
            ch = sc.next().charAt(0);
            while (ch == 'y'){
                System.out.print("Enter data at the starting of LinkedList: ");
                int data = sc.nextInt();
                ll.addFirst(data);
                System.out.print("Want to enter more data ? (y/n): ");
                ch = sc.next().charAt(0);
            }

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

            // addmiddle

            // removeFirst
            System.out.print("Want to remove data from the starting of LinkedList? (y/n): ");
            ch = sc.next().charAt(0);
            while (ch == 'y') {
                System.out.println(removeFirst() + " get removed from LinkedList");
                System.out.print("Want to remove more data ? (y/n): ");
                ch = sc.next().charAt(0);
            }

            // removeLast
            System.out.print("Want to remove data from the end of LinkedList? (y/n): ");
            ch = sc.next().charAt(0);
            while (ch == 'y') {
                System.out.println(removeLast() + " get removed from LinkedList");
                System.out.print("Want to remove more data ? (y/n): ");
                ch = sc.next().charAt(0);
            }

            // print
            System.out.print("Want to print LinkedList? (y/n): ");
            ch = sc.next().charAt(0);
            if(ch == 'y'){
            System.out.println("LinkedList is: ");
            printLL();
            }

            // search
            System.out.print("Want to search data in LinkedList? (y/n): ");
            ch = sc.next().charAt(0);
            while (ch == 'y') {
                System.out.print("Enter data of that node in LinkedList: ");
                int key = sc.nextInt();
                System.out.println(key + " found at " + search(key));
                System.out.print("Want to search more data ? (y/n): ");
                ch = sc.next().charAt(0);
            }

        }catch(Exception e){
            System.out.println(e);
        }
       
    }
}
