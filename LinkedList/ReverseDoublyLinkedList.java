import java.util.*;
public class ReverseDoublyLinkedList {
  public static class DoublyLinkedList{
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node head;
    public Node tail;
    public int size = 0;

    // addLast
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    // removeLast
    public int removeLast(){
        if(head == null){
            System.out.println("Empty LinkedList");
            return -1;
        }
        int data = tail.data;
        if(head == tail){
            head = tail = null;
            size--;
            return data;
        }
        Node temp = tail;
        temp.prev.next = null;
        tail = temp.prev;
        size--;
        return data;
    }

    // print
    public void print(){
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    // Reverse Doubly LL
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
  }
  
  public static void main(String args[]) {
      try (Scanner sc = new Scanner(System.in)) {
          DoublyLinkedList ll = new DoublyLinkedList();
          char ch;
          // addLast
          System.out.print("Want to enter data at the end of Doubly LinkedList? (y/n): ");
          ch = sc.next().charAt(0);
          while (ch == 'y') {
              System.out.print("Enter data at the end of Doubly LinkedList: ");
              int data = sc.nextInt();
              ll.addLast(data);
              System.out.print("Want to enter more data ? (y/n): ");
              ch = sc.next().charAt(0);
          }

          // removeLast
          System.out.print("Want to remove data from the end of Doubly LinkedList? (y/n): ");
          ch = sc.next().charAt(0);
          while (ch == 'y') {
              System.out.println(ll.removeLast() + " get removed from Doubly LinkedList");
              System.out.print("Want to remove more data ? (y/n): ");
              ch = sc.next().charAt(0);
          }

          // print
          System.out.print("Want to print Doubly LinkedList? (y/n): ");
          ch = sc.next().charAt(0);
          if (ch == 'y') {
              System.out.println("Doubly LinkedList is: ");
              ll.print();
          }

          // ReverseLL
          System.out.print("\nWant to reverse Doubly LinkedList? (y/n): ");
          ch = sc.next().charAt(0);
          if (ch == 'y') {
              ll.reverse();
              System.out.println("After reversing Doubly LinkedList becomes: ");
              ll.print();
          }

      } catch (Exception e) {
          System.out.println(e);
      }

  }
}
