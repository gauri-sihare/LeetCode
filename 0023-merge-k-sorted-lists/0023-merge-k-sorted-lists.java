class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeHelper(lists, 0, lists.length - 1);
    }

    public ListNode mergeHelper(ListNode[] lists, int start, int end) {

        // Only one list left
        if (start == end) {
            return lists[start];
        }

        // Two lists left
        if (start + 1 == end) {
            return merge2list(lists[start], lists[end]);
        }

        int mid = start + (end - start) / 2;

        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);

        return merge2list(left, right);
    }

    public ListNode merge2list(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        // Attach remaining nodes
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }
}