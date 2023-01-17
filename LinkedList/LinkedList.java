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

        public static void addFirst(int data){
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
    }
}
