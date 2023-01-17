import java.util.*;
public class SearchInLinkedList{
    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node head = null;
    static Node tail = null;

    public static int search(int key){
        if(head == null){
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        }
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Element not found! ");
        return Integer.MIN_VALUE;
    }

    public static void main(String args[]){
        Node head = new Node(1);
        do{

        }while(true);
    }
}