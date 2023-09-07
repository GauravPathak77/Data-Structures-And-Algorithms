import java.util.*;
public class Reverse_LL_2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode temp = head;
            ListNode newtemp = head;
            int size = 1;
            if (left != 1) {
                while (size != left - 1 && temp != null) {
                    temp = temp.next;
                    newtemp = newtemp.next;
                    size++;
                }
                if (temp != null) {
                    temp = temp.next;
                    size++;
                    ListNode prev = newtemp.next;
                    ListNode curr = temp.next;
                    ListNode next;
                    while (size != right && curr != null) {
                        next = curr.next;
                        curr.next = prev;
                        prev = curr;
                        curr = next;
                        size++;
                    }
                    temp.next = curr;
                    newtemp.next = prev;
                }
            } else {
                while (size <= right && newtemp != null) {
                    newtemp = newtemp.next;
                    size++;
                }
                ListNode prev = newtemp;
                ;
                ListNode curr = head;
                ListNode next;
                size = 1;
                while (curr != null && size <= right) {
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    size++;
                }
                head = prev;
            }
            return head;
        }
}
