import java.util.*;
public class CheckLinkedListIsPallindrome {
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

    // Slow-fast approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Check Pallindrome
    public boolean checkPallindrome(){
        if(head == null || head.next == null){
            return true;
        }
        // middle node
        Node midNode = findMid(head);
        // Reverse LL After Middle node
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        // compare both sides
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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
        System.out.print("\nWant to check LinkedList is Pallindrome or not? (y/n): ");
        ch = sc.next().charAt(0);
        if (ch == 'y') {
            if(ll.checkPallindrome()){
                System.out.print("LinkedList is Pallindrome");
            }
            else{
                System.out.print("LinkedList is not Pallindrome");
            }
        }

    } catch (Exception e) {
        System.out.println(e);
    }

}
}
