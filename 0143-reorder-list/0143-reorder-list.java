/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return ;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
             slow = slow.next;
        }
         ListNode mid = slow;
         
       
        ListNode curr = mid.next;
        mid.next = null;

        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
             curr.next = prev;
            prev = curr;
            curr = next;
}

        ListNode first = head;
        ListNode sec = prev;

        while(sec!= null){
            ListNode temp1 = first.next;
            ListNode  temp2 = sec.next;
            first.next = sec;
            sec.next = temp1;
            first = temp1;
            sec = temp2;
        }
    }
}