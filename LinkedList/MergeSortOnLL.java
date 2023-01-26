import java.util.*;
public class MergeSortOnLL {
    public static class LinkedList {
    public static class Node {
        int data;
        Node next;

        public  Node(int data) {
            this.data = data;
            this.next = null;
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
            return;
        }
        tail.next = newNode;
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
    public void printLL(){
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

    // Merge Sort
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            temp = temp.next;
            head1 = head1.next; 
        }
        while(head2 != null){
            temp.next = head2;
            temp = temp.next;
            head2 = head2.next; 
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft,newRight);
    }
}
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            LinkedList ll = new LinkedList();
            char choice;
            do{
                System.out.print("Enter data in LinkedList: ");
                int data = sc.nextInt();
                ll.addLast(data);
                System.out.print("Want to enter more data?(y/n): ");
                choice = sc.next().charAt(0);
            }while(choice == 'y');
            System.out.println("LinkedList Before Sorting: ");
            ll.printLL();
            ll.head = ll.mergeSort(ll.head);
            System.out.println("\nLinkedList After Sorting: ");
            ll.printLL();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}