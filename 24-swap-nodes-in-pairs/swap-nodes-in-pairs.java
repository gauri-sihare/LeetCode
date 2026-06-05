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
    public ListNode swapPairs(ListNode head) {
         ListNode dummy = new ListNode(-1);
         dummy.next = head;
         ListNode prev = dummy;
         ListNode curr = new ListNode();

         curr = head;

        

        while(curr != null && curr.next != null ){
            ListNode nxtStart = new ListNode();
            ListNode nexa = curr.next;
            prev.next = curr.next;
            
            
            nxtStart = curr.next.next;
            nexa.next = curr ;
            curr.next = nxtStart;
            
            prev = curr;
            curr = nxtStart;
            
        }
    return dummy.next;
    }
}