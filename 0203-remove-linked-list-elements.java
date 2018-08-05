/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        ListNode t1 = dummyHead;
        ListNode t2 = head;
        while (t2 != null) {
            while (t2 != null && t2.val == val) {
                t2 = t2.next;
            } 
            t1.next = t2;
            t1 = t2;
            if (t2 != null) t2 = t2.next;
        }
        
        return dummyHead.next;
    }
}
