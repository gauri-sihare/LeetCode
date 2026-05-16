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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode starter = new ListNode(Integer.MAX_VALUE);
        ListNode newHead = starter;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val ){
                starter.next = list1;
                list1 = list1.next;
            }else{
                starter.next = list2;
                list2 =  list2.next;
            }
            starter = starter.next;
        }

        if(list1 == null){
            starter.next = list2;

        }else{
            starter.next = list1;
           
        }
        return newHead.next;
    }
}